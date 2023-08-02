package com.example.shoesstore.presenter.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoesstore.model.Shoe
class ShoeListScreenViewModel : ViewModel() {

    val shoeName = ObservableField<String>()
    val company = ObservableField<String>()
    val shoeSize = ObservableField<String>()
    val description = ObservableField<String>()

    private val shoeListLiveData: MutableLiveData<List<Shoe>> = MutableLiveData(mutableListOf())

    fun getShoeListLiveData(): LiveData<List<Shoe>> {
        return shoeListLiveData
    }

    fun addShoe() {
        val name = shoeName.get() ?: ""
        val brand = company.get() ?: ""
        val price = shoeSize.get()?.toDoubleOrNull() ?: 0.0
        val desc = description.get() ?: ""

        val shoe = Shoe(name, brand, price, desc)
        val currentShoes = shoeListLiveData.value?.toMutableList() ?: mutableListOf()
        currentShoes.add(shoe)
        shoeListLiveData.value = currentShoes

        shoeName.set("")
        company.set("")
        shoeSize.set("")
        description.set("")
    }

    fun onCancelClick() {
        shoeName.set("")
        company.set("")
        shoeSize.set("")
        description.set("")
    }
}