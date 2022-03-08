package com.androiddev.rickandmorty.network

import com.androiddev.rickandmorty.network.response.GetCharacterByIdResponse
import retrofit2.Response

class ApiClient (private val rickAndMortyService: RickAndMortyService){


    suspend fun getChracterById(characterId: Int):Response<GetCharacterByIdResponse> {
        return rickAndMortyService.getCharacterById(characterId)
    }

    /*
    *burdaki fonksiyon interface deki  çağrıyı(call) yapan interface i taklit ediyor.
     */

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }
}