package com.example.weatherapp2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp2.adapters.WeatherModel

// ViewModel для управления данными приложения
class MainViewModel : ViewModel() {
     // LiveData для текущей погоды
     val liveDataCurrent = MutableLiveData<WeatherModel>()
     // LiveData для списка прогноза погоды
     val liveDataList = MutableLiveData<List<WeatherModel>>()
}