package com.androiddev.rickandmorty.characters.detail

import com.airbnb.epoxy.EpoxyController

class CharacterDetailsEpoxyController : EpoxyController() {


    var isLoading: Boolean = true
        set(value) {
            field = value
            if (field){
                requestModelBuild()
            }
        }


    override fun buildModels() {
        TODO("Not yet implemented")
    }


}