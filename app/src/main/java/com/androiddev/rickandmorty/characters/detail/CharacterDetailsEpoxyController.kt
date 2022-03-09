package com.androiddev.rickandmorty.characters.detail

import com.airbnb.epoxy.EpoxyController
import com.androiddev.rickandmorty.R
import com.androiddev.rickandmorty.databinding.ModelCharacterDetailsDataPointBinding
import com.androiddev.rickandmorty.databinding.ModelCharacterDetailsHeaderBinding
import com.androiddev.rickandmorty.databinding.ModelCharacterDetailsImageBinding
import com.androiddev.rickandmorty.epoxy.LoadingEpoxyModel
import com.androiddev.rickandmorty.epoxy.ViewBindingKotlinModel
import com.androiddev.rickandmorty.network.response.GetCharacterByIdResponse
import com.squareup.picasso.Picasso

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
            LoadingEpoxyModel().id("loading").addTo(this)
            return
        }

        if (characterResponse == null){
            // todo error state
            return
        }

        // header model ekle
        HeaderEpoxyModel(
            name = characterResponse!!.name,
            gender = characterResponse!!.gender,
            status = characterResponse!!.status
        ).id("header").addTo(this)


        //add image model
        ImageEpoxyModel(
            imageUrl = characterResponse!!.image
        ).id("image").addTo(this)


        //add the data points model
        DataPointEpoxyModel(
            title = "Origin",
            description = characterResponse!!.origin.name
        ).id("data_point_1").addTo(this)

        DataPointEpoxyModel(
            title = "Species",
            description = characterResponse!!.species
        ).id("data_point_2").addTo(this)
    }

    data class HeaderEpoxyModel(
        val name: String,
        val gender: String,
        val status: String
    ): ViewBindingKotlinModel<ModelCharacterDetailsHeaderBinding>(R.layout.model_character_details_header){

        override fun ModelCharacterDetailsHeaderBinding.bind() {
            nameTextView.text = name
            aliveTextView.text = status

            if (gender.equals("male",true)){
                genderImageView.setImageResource(R.drawable.ic_baseline_male_24)
            }else{
                genderImageView.setImageResource(R.drawable.ic_baseline_female_24)
            }
        }
    }


    //internet gelen verileri kendi view larımıza bind ediyor yani bağlıyoruz
    data class ImageEpoxyModel(
        val imageUrl: String,
    ): ViewBindingKotlinModel<ModelCharacterDetailsImageBinding>(R.layout.model_character_details_data_point) {

        override fun ModelCharacterDetailsImageBinding.bind() {
            Picasso.get().load(imageUrl).into(headerImageView)
        }
    }

    data class DataPointEpoxyModel(
        val title: String,
        val description: String
    ): ViewBindingKotlinModel<ModelCharacterDetailsDataPointBinding>(R.layout.model_character_details_data_point){


        override fun ModelCharacterDetailsDataPointBinding.bind() {
            labelTextView.text = title
            textView.text = description
        }
    }




}