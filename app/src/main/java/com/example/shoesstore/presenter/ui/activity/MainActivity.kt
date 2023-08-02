package com.example.shoesstore.presenter.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import com.example.shoesstore.R
import com.example.shoesstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val navHostFragment = NavHostFragment.create(R.navigation.navigation)
            supportFragmentManager.commit {
                replace(R.id.container, navHostFragment)
                setPrimaryNavigationFragment(navHostFragment)
            }
        }
    }

}