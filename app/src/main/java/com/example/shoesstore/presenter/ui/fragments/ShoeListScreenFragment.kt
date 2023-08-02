package com.example.shoesstore.presenter.ui.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoesstore.R
import com.example.shoesstore.databinding.ActivityShoeListScreenBinding
import com.example.shoesstore.presenter.ui.activity.MainActivity
import com.example.shoesstore.presenter.viewmodel.ShoeListScreenViewModel

class ShoeListFragment : Fragment() {

    private lateinit var binding: ActivityShoeListScreenBinding
    private val shoeListScreenViewModel: ShoeListScreenViewModel by activityViewModels()
    private lateinit var allShoeItemsLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityShoeListScreenBinding.inflate(inflater, container, false)
        allShoeItemsLayout = binding.allShoeItems

        setHasOptionsMenu(true)

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shoeListScreenViewModel.getShoeListLiveData().observe(viewLifecycleOwner, Observer { shoes ->
            allShoeItemsLayout.removeAllViews()

            for (shoe in shoes) {
                val shoeTextView = TextView(requireContext())
                shoeTextView.text = "Shoe: ${shoe.name}\nBrand: ${shoe.brand}\nPrice: ${shoe.price}\n" +
                        "Description: ${shoe.description}"
                allShoeItemsLayout.addView(shoeTextView)
            }
        })

        binding.fabShoeDetail.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_detailShoeScreenFragment)
        }
    }

    private fun logoutAndNavigateToMainActivity() {
        // Implement your logout logic here
        // For example, you can clear the user session or perform any other necessary operations before navigating

        // Navigate to MainActivity
        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.shoe_list_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                logoutAndNavigateToMainActivity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
