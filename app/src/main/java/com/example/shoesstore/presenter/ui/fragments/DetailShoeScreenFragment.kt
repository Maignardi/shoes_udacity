package com.example.shoesstore.presenter.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.shoesstore.R
import com.example.shoesstore.databinding.FragmentDetailShoeScreenBinding
import com.example.shoesstore.model.Shoe
import com.example.shoesstore.presenter.viewmodel.ShoeListScreenViewModel

class DetailShoeScreenFragment : Fragment() {

    private var _binding: FragmentDetailShoeScreenBinding? = null
    private val binding get() = _binding!!

    private val shoeListScreenViewModel: ShoeListScreenViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailShoeScreenBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = shoeListScreenViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        val btnCancel = binding.btnCancel
        val btnSave = binding.btnSave

        btnCancel.setOnClickListener {
            shoeListScreenViewModel.onCancelClick()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.detailShoeScreenFragment, true)
                .build()
            findNavController().navigate(R.id.action_detailShoeScreenFragment_to_shoeListFragment, null, navOptions)
        }

        btnSave.setOnClickListener {
            val shoeName = shoeListScreenViewModel.shoeName.get() ?: ""
            val company = shoeListScreenViewModel.company.get() ?: ""
            val shoeSize = shoeListScreenViewModel.shoeSize.get()?.toDoubleOrNull() ?: 0.0
            val description = shoeListScreenViewModel.description.get() ?: ""

            if (shoeSize != 0.0) {
                val newShoe = Shoe(shoeName, company, shoeSize, description)
                shoeListScreenViewModel.addShoe()
            }

            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.detailShoeScreenFragment, true)
                .build()
            findNavController().navigate(R.id.action_detailShoeScreenFragment_to_shoeListFragment, null, navOptions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}