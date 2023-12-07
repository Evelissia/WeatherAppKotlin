package com.example.weatherapp2.fragments

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp2.MainViewModel
import com.example.weatherapp2.R
import com.example.weatherapp2.adapters.WeatherAdapter
import com.example.weatherapp2.adapters.WeatherModel
import com.example.weatherapp2.databinding.FragmentDaysBinding

// Фрагмент для отображения прогноза погоды на несколько дней
class DaysFragment : Fragment(),  WeatherAdapter.Listener {
    private lateinit var adapter: WeatherAdapter
    private lateinit var binding: FragmentDaysBinding
    private val model: MainViewModel by activityViewModels()
    // Создание представления фрагмента
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }
    // Инициализация фрагмента после создания представления
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        // Наблюдение за изменениями в списке данных о погоде на несколько дней
        model.liveDataList.observe(viewLifecycleOwner){
            adapter.submitList(it.subList(1, it.size))
        }
    }
    // Инициализация элементов интерфейса
    private fun init() = with(binding){
        adapter = WeatherAdapter(this@DaysFragment)
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = DaysFragment()
    }
    // Обработчик события клика по элементу списка погоды на несколько дней
    override fun onClick(item: WeatherModel) {
        model.liveDataCurrent.value = item
    }
}