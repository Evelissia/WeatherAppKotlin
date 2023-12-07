package com.example.weatherapp2.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// Адаптер для ViewPager2, управляющий списком фрагментов
class VpAdapter(fa: FragmentActivity, private val list: List<Fragment>) : FragmentStateAdapter(fa) {
    // Получение количества элементов в списке фрагментов
    override fun getItemCount(): Int {
        return list.size
    }
    // Создание фрагмента на основе его позиции в списке
    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}

