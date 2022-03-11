package com.androiddev.rickandmorty.characters

import com.androiddev.rickandmorty.network.response.GetCharacterByIdResponse

class CharactersRepository {

    suspend fun getCharacterList(pageIndex: Int): List<GetCharacterByIdResponse> {
        return emptyList()
    }
    /*
    paging
     */

}
