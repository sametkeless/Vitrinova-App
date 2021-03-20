package com.tolerans.vitrinova.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tolerans.vitrinova.data.model.DiscoverItem
import com.tolerans.vitrinova.repositories.MainRepository
import com.tolerans.vitrinova.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MainViewModel @ViewModelInject constructor(val mainRepository: MainRepository) :ViewModel(){


    sealed class DiscoverEvent{
        class Success(val item: List<DiscoverItem>) :DiscoverEvent()
        class Error(val errText:String):DiscoverEvent()
        object Loading:DiscoverEvent()
        object Empty:DiscoverEvent()
    }


    private val _discoverElement = MutableStateFlow<DiscoverEvent>(DiscoverEvent.Empty)

    val discoverElement :StateFlow<DiscoverEvent> = _discoverElement


    init{

     initData()

    }

    fun initData(){
        viewModelScope.launch (Dispatchers.IO){
            _discoverElement.value = DiscoverEvent.Loading
            val discoverResponse = mainRepository.getDiscovers()
            when(discoverResponse){
                is Resource.Error ->{
                    discoverResponse.message?.let { errMsg->
                        _discoverElement.value = DiscoverEvent.Error(errMsg)
                    }

                }
                is Resource.Success ->{
                    if(discoverResponse.data!=null && discoverResponse.data.size > 0){
                        _discoverElement.value = DiscoverEvent.Success(discoverResponse.data)

                    }else{
                        _discoverElement.value = DiscoverEvent.Error("null object")
                        return@launch
                    }

                }
            }

        }

    }


}