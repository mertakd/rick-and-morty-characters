package com.androiddev.rickandmorty

import com.androiddev.rickandmorty.network.NetworkLayer
import com.androiddev.rickandmorty.network.response.GetCharacterByIdResponse

class SharedRepository {
    /*
    *Burası yani repository api ile etkileşime gireceğimiz yerdir.
     */

    suspend fun getCharacterById(characterId: Int): GetCharacterByIdResponse? {
        //network isteği gerçekleştiriyoruz.
        val request = NetworkLayer.apiClient.getCharacterById(characterId)


        if (request.failed){
            return null
        }


        //ağ isteğinden(network request) döndükden sonra ne olacak. isteğin başarı olup olmadığı durumlarda işlem yapabiliriz.
        if (!request.isSuccessful){
            return null
        }

        return null //başarısızlık durumunda null döndür

    }

}