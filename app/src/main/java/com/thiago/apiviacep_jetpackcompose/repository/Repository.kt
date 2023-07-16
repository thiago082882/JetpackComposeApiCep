package com.thiago.apiviacep_jetpackcompose.repository

import com.thiago.apiviacep_jetpackcompose.data.DataSource
import com.thiago.apiviacep_jetpackcompose.listener.RespostaApi
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository @Inject constructor(
    private val dataSource: DataSource
) {

    fun respostaApi(cep:String,respostaApi: RespostaApi){
dataSource.respostaApi(cep,respostaApi)
    }
}