package com.example.qoute.reposertry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.qoute.apiinterface.QoutesApi
import com.example.qoute.model.qoutesmodel.QouteModel
import javax.inject.Inject


class QoutesRepo @Inject constructor(val api2: QoutesApi) {


    private val qoutesLiveData= MutableLiveData<QouteModel>()

     val qoutes:LiveData<QouteModel>
         get() =qoutesLiveData


    suspend fun qoutesApi(){

        val result=api2.serviceQoutes()
        if(result.body()!=null){
          qoutesLiveData.postValue(result.body())
        }
    }


}