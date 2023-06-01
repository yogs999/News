package com.example.qoute.apiinterface


import com.example.qoute.model.qoutesmodel.QouteModel
import retrofit2.Response
import retrofit2.http.GET

interface QoutesApi {

  @GET("/api/quotes")
  suspend fun serviceQoutes(): Response<QouteModel>
}


