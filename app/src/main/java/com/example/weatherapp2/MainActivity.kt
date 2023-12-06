package com.example.weatherapp2

import android.app.VoiceInteractor.Request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.privacysandbox.tools.core.model.Method
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapp2.databinding.ActivityMainBinding
import com.example.weatherapp2.fragments.MainFragment
import org.json.JSONObject

const val API_KEY = "235f0c8bd44c499f8c581800230612"

class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction().replace(R.id.placeHolder, MainFragment.newInstance())
            .commit()


        /*binding.bGet.setOnClickListener {
            getResult("London")
        }*/
    }
    /*private fun getResult(name: String) {
         val url = "https://api.weatherapi.com/v1/current.json"+
                 "?key=$API_KEY&q=$name&aqi=no"
         val queue = Volley.newRequestQueue(this)
         val stringRequest = StringRequest(com.android.volley.Request.Method.GET,
             url,
             {
                 response->
                 val obj = JSONObject(response)
                 val temp = obj.getJSONObject("current" )
                 Log.d("MyLog", "Response: ${temp.getString("temp_c")}")
             },
             {
                Log.d("MyLog", "VolleyError: $it")
             }
             )
        queue.add(stringRequest)
    }*/
}