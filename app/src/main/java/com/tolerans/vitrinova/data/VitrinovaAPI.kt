package com.tolerans.vitrinova.data

import com.tolerans.vitrinova.data.model.DiscoverItem
import retrofit2.Response
import retrofit2.http.GET

interface VitrinovaAPI {

    @GET("discover")
    suspend fun getValueDiscover(): Response<List<DiscoverItem>>

}