package com.androiddev.rickandmorty.characters.detail

import com.airbnb.epoxy.EpoxyController
import com.androiddev.rickandmorty.network.response.GetCharacterByIdResponse

class CharacterDetailsEpoxyController : EpoxyController() {


    var isLoading: Boolean = true
        set(value) {
            field = value
            if (field){
                requestModelBuild()
            }
        }


    var characterResponse: GetCharacterByIdResponse? = null
        set(value) {
            field = value
            if (field != null){
                isLoading = false
                requestModelBuild()
            }
        }

    override fun buildModels() {
        //kullanıcı arayüzü(ui) güncellenmesi gerektiğinde yapılacak işlemler
        //arayüzün neye benzediğini kontrol edebiliriz burada
        if(isLoading){
            //loading durumunu göster
            return
        }

        //add header model
        //add image model
        //add the data points model


    }


}