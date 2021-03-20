package com.tolerans.vitrinova.repositories

import com.tolerans.vitrinova.data.VitrinovaAPI
import com.tolerans.vitrinova.data.model.DiscoverItem
import com.tolerans.vitrinova.util.Resource
import java.lang.Exception
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(private val api: VitrinovaAPI):MainRepository {
    override suspend fun getDiscovers():Resource<List<DiscoverItem>>{
       return try {

           val response = api.getValueDiscover()
            val result = response.body()
           if(result !=null)
              Resource.Success(result)
           else
               Resource.Error(response.message())

        }catch (e:Exception){
             Resource.Error(e.message!!)
        }
    }



}