package com.polodarb.volans.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.MaterialTimePicker.INPUT_MODE_CLOCK
import com.google.android.material.timepicker.TimeFormat
import com.polodarb.volans.R
import com.polodarb.volans.data.local.entities.Flight
import com.polodarb.volans.databinding.FragmentAdminBinding
import com.polodarb.volans.ui.viewModels.AdminViewModel
import com.polodarb.volans.ui.viewModels.CityUiState
import com.polodarb.volans.ui.viewModels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class AdminFragment : Fragment() {

    private val binding: FragmentAdminBinding by lazy { FragmentAdminBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.window?.statusBarColor = resources.getColor(R.color.white, null)

        val viewModel: AdminViewModel by viewModels()

        viewModel.getCity()

        val placesArray = mutableListOf<String>()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.city.collect { uiState ->
                    when (uiState) {
                        is CityUiState.Success -> {
                            placesArray.addAll(uiState.flight)
                        }

                        is CityUiState.Loading -> {}

                        is CityUiState.Error -> {}
                    }
                }
            }
        }

        binding.etPlaceOfDeparture.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Place of departure")
                .setNegativeButton("Cancel") { dialog, which ->
                    // Respond to negative button press
                }
                .setPositiveButton("OK") { dialog, which ->
                    // Respond to positive button press
                }
                .setSingleChoiceItems(
                    placesArray.toTypedArray(), -1
                ) { dialog, which ->
                    val selectedPlace = placesArray[which]
                    binding.etPlaceOfDeparture.setText(selectedPlace)
                }
                .show()
        }

        binding.etLandingPlace.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Landing place")
                .setNegativeButton("Cancel") { dialog, which ->
                    // Respond to negative button press
                }
                .setPositiveButton("OK") { dialog, which ->
                    // Respond to positive button press
                }
                .setSingleChoiceItems(
                    placesArray.toTypedArray(), -1
                ) { dialog, which ->
                    val selectedPlace = placesArray[which]
                    binding.etLandingPlace.setText(selectedPlace)
                }
                .show()
        }

        val constraintsBuilder =
            CalendarConstraints.Builder()
                .setValidator(DateValidatorPointForward.now())

        val pickerDateDeparture =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select departure date")
                .setCalendarConstraints(constraintsBuilder.build())
                .build()

        val pickerTimeDeparture =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setInputMode(INPUT_MODE_CLOCK)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select departure time")
                .build()

        val pickerTimeLanding =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setInputMode(INPUT_MODE_CLOCK)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select departure time")
                .build()

        pickerTimeDeparture.addOnPositiveButtonClickListener {
            val formattedMinute = String.format("%02d", pickerTimeDeparture.minute)
            binding.etDepartureTime.setText("${pickerTimeDeparture.hour}:${formattedMinute}")
        }

        pickerTimeLanding.addOnPositiveButtonClickListener {
            val formattedMinute = String.format("%02d", pickerTimeLanding.minute)
            binding.etLandingTime.setText("${pickerTimeLanding.hour}:${formattedMinute}")
        }

        pickerDateDeparture.addOnPositiveButtonClickListener {

            val date = Date(pickerDateDeparture.selection ?: 0)
            val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
            val formattedDate1 = dateFormat.format(date)

            binding.etDepartureDate.setText(formattedDate1)
        }

        binding.etDepartureTime.setOnClickListener {
            pickerTimeDeparture.show(childFragmentManager, "etDepartureTime")
        }

        binding.etLandingTime.setOnClickListener {
            pickerTimeLanding.show(childFragmentManager, "etLandingTime")
        }

        binding.etDepartureDate.setOnClickListener {
            pickerDateDeparture.show(childFragmentManager, "tag")
        }

        binding.btnCreateTicket.setOnClickListener {
            if (
                binding.etDepartureDate.text.isEmpty()
                or binding.etDepartureTime.text.isEmpty()
                or binding.etLandingPlace.text.isEmpty()
                or binding.etLandingTime.text.isEmpty()
                or binding.etPrice.text.isEmpty()
                or binding.etLandingPlace.text.isEmpty()
            ) {
                Toast.makeText(requireContext(), "Not all fields are full!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val departureTime = binding.etDepartureTime.text.toString()
                val arrivalTime = binding.etLandingTime.text.toString()
                val departureDate = binding.etDepartureDate.text.toString()

                val sdf = SimpleDateFormat("dd.MM.yy")
                val departureDateTime = sdf.parse("$departureDate $departureTime")
                val arrivalDateTime = sdf.parse("$departureDate $arrivalTime")

                val calendar = Calendar.getInstance()
                calendar.time = departureDateTime

                if (arrivalDateTime.before(departureDateTime)) {
                    calendar.add(Calendar.DAY_OF_MONTH, 1)
                }

                val arrivalDate = sdf.format(calendar.time)

                val departureCodeList = viewModel.getDepartureCodeByCity(binding.etPlaceOfDeparture.text.toString()).value
                val departureCode = departureCodeList?.firstOrNull() ?: 0

                val arrivalCodeList = viewModel.getArrivalCodeByCity(binding.etLandingPlace.text.toString()).value
                val arrivalCode = arrivalCodeList?.firstOrNull() ?: 0

                Log.wtf("123", "departureCode - $departureCode")
                Log.wtf("123", "arrivalCode - $arrivalCode")

//                CoroutineScope(Dispatchers.IO).launch {
//                    viewModel.addFlight(
//                        Flight(
//                            flightCode = 55,
//                            departureCode = departureCode,
//                            arrivalCode = arrivalCode,
//                            departureTime = binding.etDepartureTime.text.toString(),
//                            departureDate = binding.etDepartureDate.text.toString(),
//                            arrivalDate = arrivalDate,
//                            arrivalTime = binding.etLandingTime.text.toString(),
//                            price = binding.etPrice.text.toString().toInt()
//                        )
//                    )
//                }
            }
        }
    }

}