package com.example.fragment_viewmodel_example

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val inputPerson = MutableLiveData<Person>()

}