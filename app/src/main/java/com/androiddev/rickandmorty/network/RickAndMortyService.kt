package com.androiddev.rickandmorty.network

import com.androiddev.rickandmorty.network.response.GetCharacterByIdResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {

    @GET("character/{character-id}") //character id nin olduğu yere yani kıvırcık paranteze placeholder deniliyor.
    suspend fun getCharacterById(@Path("character-id") characterId: Int): Response<GetCharacterByIdResponse>


}