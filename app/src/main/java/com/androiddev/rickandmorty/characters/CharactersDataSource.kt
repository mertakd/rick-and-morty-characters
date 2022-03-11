package com.androiddev.rickandmorty.characters

import androidx.paging.PageKeyedDataSource
import com.androiddev.rickandmorty.SharedViewModel
import com.androiddev.rickandmorty.network.response.GetCharacterByIdResponse
import kotlinx.coroutines.coroutineScope

class CharactersDataSource(
    private val viewModel: SharedViewModel,
    private val repository: CharactersRepository
): PageKeyedDataSource<Int, GetCharacterByIdResponse>(){


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, GetCharacterByIdResponse>
    ) {

    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GetCharacterByIdResponse>
    ) {

    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GetCharacterByIdResponse>
    ) {

    }




}