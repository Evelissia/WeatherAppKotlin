package com.example.weatherapp2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapp2.R
import com.example.weatherapp2.adapters.VpAdapter
import com.example.weatherapp2.databinding.ActivityMainBinding
import com.example.weatherapp2.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

const val API_KEY = "235f0c8bd44c499f8c581800230612"
class MainFragment : Fragment() {
    private val fList = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )

    private val tList = listOf(
        "HOURS",
        "DAYS"
    )
    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        init()
        requestWeatherData("London")
    }

    private fun init() = with(binding){
        val adapter = VpAdapter(activity as FragmentActivity, fList)
        vp.adapter = adapter
        TabLayoutMediator(tabLayout3, vp){
            tab, pos -> tab.text = tList[pos]
        }.attach()
    }

     private fun permissionListener() {
         pLauncher = registerForActivityResult(
             ActivityResultContracts.RequestPermission()){
             Toast.makeText(activity, "Permission is $it", Toast.LENGTH_LONG).show()
         }
     }

    private fun checkPermission(){
        if(!isPermissionGranted(android.Manifest.permission.ACCESS_FINE_LOCATION)){
            permissionListener()
            pLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun requestWeatherData(city: String){
        val url = "https://api.weatherapi.com/v1/forecast.json?key=" +
                API_KEY +
                "&q=" +
                city +
                "&days=" +
                "3" +
                "&aqi=no&alerts=no"
        val queue = Volley.newRequestQueue(context)
        val request = StringRequest(
            Request.Method.GET,
            url,
            {
                result -> Log.d("MyLog", "Resulr: $result")
            },

            {
                error -> Log.d("MyLog", "Error: $error")
            }
        )
        queue.add(request)
    }



    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()

    }
}