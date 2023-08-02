package com.example.shoesstore.presenter.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.shoesstore.R
import com.example.shoesstore.databinding.FragmentLoginBinding

class loginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        verifitClickBottoms()
        return binding.root
    }

    fun verifitClickBottoms() {
        binding.buttonCreateLogin.setOnClickListener {
            goToWelcomeScreen()
        }
        binding.buttonLoginExistingAccount.setOnClickListener {
            goToWelcomeScreen()
        }
    }

    fun goToWelcomeScreen() {
        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.welcomeScreenFragment, true)
            .build()

        findNavController().navigate(R.id.action_loginFragment_to_welcomeScreenFragment, null, navOptions)
    }

}