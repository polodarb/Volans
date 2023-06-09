package com.polodarb.volans.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.MaterialTimePicker.INPUT_MODE_CLOCK
import com.google.android.material.timepicker.TimeFormat
import com.polodarb.volans.R
import com.polodarb.volans.data.local.entities.Airport
import com.polodarb.volans.data.local.entities.Flight
import com.polodarb.volans.databinding.FragmentAdminBinding
import com.polodarb.volans.ui.viewModels.AdminViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
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


//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.addAirport(
//                Airport(
//                    airportCode = 0,
//                    airportCountry = "Ukraine",
//                    airportName = "[KHA]",
//                    airportCity = "Kiyv"
//                )
//            )
//        }

//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.addFlight(
//                Flight(
//                    flightCode = 0,
//                    departureCode = 0,
//                    arrivalCode = 0,
//                    departureDate = "06/06/2023",
//                    departureTime = "23:30",
//                    arrivalTime = "7:00",
//                    price = 15000f
//                )
//            )
//        }

        val placesArray = arrayOf(
            "Kharkiv, Ukraine",
            "Kiyv, Ukraine",
            "Seattle, USA",
            "NY, USA",
            "London, UK",
            "Paris, France",
            "Berlin, Germany",
            "Prague, Czech Republic",
            "Hong Kong, China",
            "Tokyo, Japan",
            "Istanbul, Turkey",
            "Frankfurt, Germany",
            "Dublin, Ireland",
            "Rome, Italy"
        )

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
                    placesArray, -1
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
                    placesArray, -1
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
    }

}