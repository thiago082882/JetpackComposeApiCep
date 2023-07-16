package com.thiago.apiviacep_jetpackcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.apiviacep_jetpackcompose.listener.RespostaApi
import com.thiago.apiviacep_jetpackcompose.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuscarCepViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){

    fun respostaApi(cep:String,respostaApi: RespostaApi){
        viewModelScope.launch {
            repository.respostaApi(cep,respostaApi)
        }
    }
}