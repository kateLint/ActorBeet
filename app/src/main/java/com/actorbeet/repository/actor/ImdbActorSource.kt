package com.actorbeet.repository.actor

import com.actorbeet.model.Actor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ImdbActorSource {

    private val BASE_URL = "https://movie-details1.p.rapidapi.com/imdb_api/"
    fun buildRetrofit()
    {
        val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)

         .addConverterFactory(GsonConverterFactory.create())
        .build()

        val movieService: MovieService = retrofit.create(MovieService::class.java)


        val actor: Call<Actor> = movieService.getActor("nm0000288")



        actor.enqueue(object : Callback<Actor> {
            override fun onResponse(call: Call<Actor>, response: Response<Actor>) {
                val actorInfo: Actor? = response.body()
                println("Kate actorInfo =" + actorInfo)
            }

            override fun onFailure(call: Call<Actor>, t: Throwable?) {
                println("Kate Failure")
            }
        })

    }

}