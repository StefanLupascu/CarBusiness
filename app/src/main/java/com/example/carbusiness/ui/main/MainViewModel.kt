package com.example.carbusiness.ui.main

import androidx.lifecycle.ViewModel
import com.example.carbusiness.data.repository.CarsRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: CarsRepository): ViewModel() {


}