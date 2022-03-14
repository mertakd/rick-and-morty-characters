package com.androiddev.rickandmorty.characters

import androidx.paging.PageKeyedDataSource
import com.androiddev.rickandmorty.SharedViewModel
import com.androiddev.rickandmorty.network.response.GetCharacterByIdResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class CharactersDataSource(
    private val coroutineScope: CoroutineScope,
    private val repository: CharactersRepository
): PageKeyedDataSource<Int, GetCharacterByIdResponse>(){


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, GetCharacterByIdResponse>
    ) {
        coroutineScope.launch {
            val characterList = repository.getCharacterList(1)
            callback.onResult(characterList, null, 2)
        }


    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GetCharacterByIdResponse>
    ) {
        coroutineScope.launch {
            val characterList = repository.getCharacterList(params.key)
            callback.onResult(characterList,  params.key + 1 )
        }

    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GetCharacterByIdResponse>
    ) {

    }




}