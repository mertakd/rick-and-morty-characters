package com.androiddev.rickandmorty

import com.androiddev.rickandmorty.response.GetCharacterByIdResponse

class SharedRepository {
    /*
    *Burası yani repository api ile etkileşime gireceğimiz yerdir.
     */

    suspend fun getCharacterById(characterId: Int): GetCharacterByIdResponse? {
        //network isteği gerçekleştiriyoruz.
        val request = NetworkLayer.apiClient.getChracterById(characterId)


        //ağ isteğinden(network request) döndükden sonra ne olacak. isteğin başarı olup olmadığı durumlarda işlem yapabiliriz.
        if (request.isSuccessful){
            return request.body()!!
        }

        return null //başarısızlık durumunda null döndür

    }

}