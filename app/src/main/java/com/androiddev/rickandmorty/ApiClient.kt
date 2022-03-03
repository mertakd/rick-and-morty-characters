package com.androiddev.rickandmorty

import com.androiddev.rickandmorty.response.GetCharacterByIdResponse
import retrofit2.Response

class ApiClient (private val rickAndMortyService: RickAndMortyService){


    suspend fun getChracterById(characterId: Int):Response<GetCharacterByIdResponse> {
        return rickAndMortyService.getCharacterById(characterId)
    }
}