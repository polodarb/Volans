package com.polodarb.volans.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.polodarb.volans.R
import com.polodarb.volans.databinding.FragmentHomeBinding
import com.polodarb.volans.ui.recyclers.HomeFlightCardAdapter
import com.polodarb.volans.ui.recyclers.ItemClickListener
import com.polodarb.volans.ui.viewModels.CityUiState
import com.polodarb.volans.ui.viewModels.HomeViewModel
import com.polodarb.volans.ui.viewModels.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val binding: FragmentHomeBinding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        activity?.window?.statusBarColor = resources.getColor(R.color.background_btn_card, null)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.outlineProvider = null

        val viewModel: HomeViewModel by viewModels()

        viewModel.getCity()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.state.collect { uiState ->
                    when (uiState) {
                        is UiState.Success -> {
                            val adapter = HomeFlightCardAdapter(uiState.flight,
                                object : ItemClickListener {
                                    override fun itemOnClick(item: Int) {
                                        findNavController().navigate(R.id.action_homeFragment_to_ticketDetailFragment)
                                        setFragmentResult("requestKey", bundleOf("bundleKey" to item))
                                    }
                                })
                            binding.rvFlightCardHome.adapter = adapter
                        }

                        is UiState.Loading -> {}

                        is UiState.Error -> {}
                    }
                }
            }
        }

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

        binding.rvFlightCardHome.layoutManager = LinearLayoutManager(requireContext())

        binding.btnChange.setOnClickListener {
            val dep = binding.etPlaceOfDeparture.text
            val arr = binding.etLandingPlace.text

            binding.etPlaceOfDeparture.text = arr
            binding.etLandingPlace.text = dep
        }

        binding.btnFilter.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_filterFragments)
        }

    }
}