package com.example.shoesstore.presenter.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.shoesstore.R
import com.example.shoesstore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)

        binding.btnGetStarted.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.welcomeScreenFragment, true)
                .build()

            findNavController().navigate(R.id.action_welcomeScreenFragment_to_instructionFragment, null, navOptions)
        }

        return binding.root
    }
}
