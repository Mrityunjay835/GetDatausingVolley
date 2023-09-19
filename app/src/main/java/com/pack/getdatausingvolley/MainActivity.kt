package com.pack.getdatausingvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pack.getdatausingvolley.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val url:String ="https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8";
    private var userInfoItemList= mutableListOf<UserInfoItem>()
    val usersInfo = UserInfo()

    private val rvAdapter by lazy{
        RvAdaptor(this,userInfoItemList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //bind the view
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter=rvAdapter

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                Log.i("APICheck", "Api is working working")
                val gson = Gson()
                val userInfoItems = gson.fromJson(response, Array<UserInfoItem>::class.java)
                userInfoItemList.addAll(userInfoItems)
//                usersInfo.addAll(userInfoItems.toList())
                rvAdapter.notifyDataSetChanged()
            },
            {
                Log.i("APICheck", "Not working")
            })


        val volleyQueue  = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)

        Log.i("testing","${usersInfo}")

    }
}

