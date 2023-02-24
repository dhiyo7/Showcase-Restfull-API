package com.plugin.showcaserestfullapi.model

import java.util.*

data class ShowcaseResponse (
    val id : Int,
    val title : String,
    val image : String,
    val description : String,
    val categoryId : String,
    val createdAt : Date,
    val updatedAt : Date
)