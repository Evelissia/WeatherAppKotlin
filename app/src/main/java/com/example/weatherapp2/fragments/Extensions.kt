package com.example.weatherapp2.fragments

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

// Функция-расширение для фрагмента, проверяющая наличие разрешения в приложении
fun Fragment.isPermissionGranted(p: String): Boolean {
    // Проверка наличия разрешения с помощью ContextCompat
    // Проверяется разрешение p для текущего фрагмента
    return ContextCompat.checkSelfPermission(
        activity as AppCompatActivity, p) == PackageManager.PERMISSION_GRANTED
}



