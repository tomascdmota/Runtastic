package com.example.runtastic.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runtastic.Repositories.MainRepository

class MainViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
): ViewModel() {

}