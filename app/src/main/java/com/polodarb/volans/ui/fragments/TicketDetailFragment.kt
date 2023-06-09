package com.polodarb.volans.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.polodarb.volans.R
import com.polodarb.volans.data.local.FlightCard
import com.polodarb.volans.data.local.entities.BuyTicket
import com.polodarb.volans.databinding.FragmentTicketDetailBinding
import com.polodarb.volans.ui.viewModels.FlightDetailUiState
import com.polodarb.volans.ui.viewModels.TicketDetaileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TicketDetailFragment : Fragment() {

    private val binding: FragmentTicketDetailBinding by lazy {
        FragmentTicketDetailBinding.inflate(
            layoutInflater
        )
    }

    var price: Int = 0
    var flightCode: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        activity?.window?.statusBarColor = resources.getColor(R.color.white, null)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: TicketDetaileViewModel by viewModels()

        setFragmentResultListener("requestKey") { _, bundle ->
            val result = bundle.getInt("bundleKey")

            Log.wtf("TAG", "$result")
            if (result != null) {
                viewModel.getTicketByFlightCode(result + 1)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.state.collect { uiState ->
                    when (uiState) {
                        is FlightDetailUiState.Success -> {
                            binding.tvTownDeparture.text = uiState.ticket.departureCity
                            binding.townLanding.text = uiState.ticket.arrivalCity
                            binding.tvDateDeparture.text = uiState.ticket.departureDate
                            binding.tvDateLanding.text = uiState.ticket.arrivalDate
                            binding.tvTimeDeparture.text = uiState.ticket.departureTime
                            binding.tvTimeLanding.text = uiState.ticket.arrivalTime
                            binding.tvFlightCode.text = "Flight code: ${uiState.ticket.flightCode}"
                            binding.place.text = "Place in plane: ${(1..120).random()}"
                            binding.price.text = "$ ${uiState.ticket.price}"
                            price = uiState.ticket.price
                        }

                        is FlightDetailUiState.Loading -> {}

                        is FlightDetailUiState.Error -> {}
                    }
                }
            }
        }

        binding.switchMd.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.price.text = "$ ${(price + price * 0.05).toInt()}"
            } else {
                binding.price.text = "$ $price"
            }
        }

//        binding.btnSearchTicket.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                viewModel.addBuyTicket(BuyTicket(
//                    0,
//                ))
//            }
//        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

}