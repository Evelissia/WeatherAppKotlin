package com.example.weatherapp2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp2.R
import com.example.weatherapp2.adapters.WeatherAdapter
import com.example.weatherapp2.adapters.WeatherModel
import com.example.weatherapp2.databinding.FragmentHoursBinding

class HoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(context)
        adapter = WeatherAdapter()
        rcView.adapter = adapter
        val list = listOf(
            WeatherModel("", "12:00",
                "Sunny", "25°C",
                "", "", "", ""),
            WeatherModel("", "13:00",
                "Sunny", "29°C",
                "", "", "", ""),
            WeatherModel("", "14:00",
                "Sunny", "31°C",
                "", "", "", "")
        )
        adapter.submitList(list)
    }
    companion object {

        @JvmStatic
        fun newInstance() = HoursFragment()

    }
}