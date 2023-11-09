package com.mikelo04.apiaplication

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mikelo04.apiaplication.api.ApiClient
import com.mikelo04.apiaplication.databinding.ActivityMainBinding
import com.mikelo04.apiaplication.response.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter(arrayListOf(), this)

        binding.rvUser.adapter = adapter
        binding.rvUser.setHasFixedSize(true)

        getuser()
    }

    fun getuser() {
        ApiClient.apiService.getUser().enqueue(object: Callback<ArrayList<ResponseModel>> {
            override fun onResponse(
                call: Call<ArrayList<ResponseModel>>,
                response: Response<ArrayList<ResponseModel>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    setAdapter(data!!)
                }
            }

            override fun onFailure(call: Call<ArrayList<ResponseModel>>, t: Throwable) {
                Log.d(TAG, "" + t.stackTraceToString())
            }

        })
    }

    fun setAdapter(data: ArrayList<ResponseModel>) {
        adapter.setData(data)
    }
}