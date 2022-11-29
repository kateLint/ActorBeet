package com.actorbeet.repository.actor

import com.actorbeet.model.Actor
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface MovieService {


    //?id=nm0000288
    @Headers(
        "X-RapidAPI-Key: 8f1da8b659msha1e0a1f0d207dbap172669jsn0fa0e200dc14",
        "X-RapidAPI-Host: movie-details1.p.rapidapi.com"
    )
    @GET("actor")
    fun getActor(@Query("id") id: String): Call<Actor>
}