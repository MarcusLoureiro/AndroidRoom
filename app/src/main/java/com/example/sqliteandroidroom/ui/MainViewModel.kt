package com.example.sqliteandroidroom.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sqliteandroidroom.Gasto
import com.example.sqliteandroidroom.service.Repository
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository): ViewModel() {

    val listGastos = MutableLiveData<List<Gasto>>()

    fun addNewGasto(gasto: Gasto){
        viewModelScope.launch {
            repository.addGastoTask(gasto)
        }
    }

    fun getAllGastos(){
        viewModelScope.launch {
            listGastos.value = repository.getAllGastosTask()
        }
    }
}