package com.example.shoesstore.presenter.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.shoesstore.R
import com.example.shoesstore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionBinding.inflate(inflater, container, false)

        binding.buttonNavigate.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.instructionFragment, true)
                .build()
            findNavController().navigate(R.id.action_instructionFragment_to_shoeListFragment, null, navOptions)
        }

        return binding.root
    }
}