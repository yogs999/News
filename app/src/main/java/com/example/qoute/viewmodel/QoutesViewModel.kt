package com.example.qoute.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qoute.model.qoutesmodel.QouteModel
import com.example.qoute.reposertry.QoutesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QoutesViewModel @Inject constructor(private val qotesRepseter: QoutesRepo) : ViewModel() {

     init {
         viewModelScope.launch(Dispatchers.IO) {
             qotesRepseter.qoutesApi()

         }
     }

       val qoutes :LiveData<QouteModel>
         get()=qotesRepseter.qoutes

}