package com.example.weatherapp2

// Класс для хранения информации о погоде на один день
data class DayItem(
    val city:String,
    val time: String,
    val condition: String,
    val imageUrl: String,
    val maxTemp: String,
    val minTemp: String,
    val hours: String
)
