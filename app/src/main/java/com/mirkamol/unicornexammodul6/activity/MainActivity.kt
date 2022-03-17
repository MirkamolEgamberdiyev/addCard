package com.mirkamol.unicornexammodul6.activity

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.unicornexammodul6.R
import com.mirkamol.unicornexammodul6.adapter.CardAdapter
import com.mirkamol.unicornexammodul6.helper.Logger
import com.mirkamol.unicornexammodul6.model.CardDataItem
import com.mirkamol.unicornexammodul6.networking.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var cardList: ArrayList<CardDataItem>
    private lateinit var adapter: CardAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        initViews()


    }

    private fun initViews() {
        cardList = ArrayList()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        refreshAdapter(cardList)
        getCards()

    }

    private fun refreshAdapter(list: ArrayList<CardDataItem>) {
        adapter = CardAdapter(this, list)
        recyclerView.adapter = adapter

    }

    private fun getCards() {
        RetrofitHttp.cardService.getAllCards().enqueue(object : Callback<ArrayList<CardDataItem>> {
            override fun onResponse(
                call: Call<ArrayList<CardDataItem>>,
                response: Response<ArrayList<CardDataItem>>
            ) {
                Logger.d("responce", response.body().toString())
                cardList.clear()
                cardList.addAll(response.body()!!)
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<ArrayList<CardDataItem>>, t: Throwable) {
                Logger.e("error", t.localizedMessage)
            }

        })
    }

    private fun isInternetAvailable(): Boolean {
        val manager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val infoMobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        val infoWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        return infoMobile!!.isConnected || infoWifi!!.isConnected
    }
}