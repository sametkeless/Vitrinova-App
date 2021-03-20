package com.tolerans.vitrinova.repositories

import com.tolerans.vitrinova.data.model.DiscoverItem
import com.tolerans.vitrinova.util.Resource

interface MainRepository {


    suspend fun getDiscovers():Resource<List<DiscoverItem>>
}