package com.androiddev.rickandmorty.network

import com.androiddev.rickandmorty.network.response.GetCharacterByIdResponse
import retrofit2.Response

class ApiClient (private val rickAndMortyService: RickAndMortyService){

    //api calls işleminin yapıldığı sınıf


    suspend fun getCharacterById(characterId: Int):SimpleResponse<GetCharacterByIdResponse> {
        return safeApiCall { rickAndMortyService.getCharacterById(characterId) } //api calls
    }

    /*
    *burdaki fonksiyon interface deki  çağrıyı(call) yapan interface i taklit ediyor.
     */

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke()) //ağ isteğinin gerçekleşeceği yer
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }
}