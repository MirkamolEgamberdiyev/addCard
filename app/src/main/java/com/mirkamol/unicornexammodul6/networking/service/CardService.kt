package com.mirkamol.unicornexammodul6.networking.service

import com.mirkamol.unicornexammodul6.model.CardDataItem
import retrofit2.Call
import retrofit2.http.GET

interface CardService {
    @GET("cards")
    fun getAllCards(): Call<ArrayList<CardDataItem>>
}