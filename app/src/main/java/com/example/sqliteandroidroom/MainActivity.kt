package com.example.sqliteandroidroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sqliteandroidroom.dao.GastosDAO
import com.example.sqliteandroidroom.database.AppDataBase
import com.example.sqliteandroidroom.service.Repository
import com.example.sqliteandroidroom.service.RepositoryImpl
import com.example.sqliteandroidroom.ui.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDataBase
    private lateinit var repo: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBD()
      //  repo = RepositoryImpl(GastosDAO)

        val viewModel by viewModels<MainViewModel> {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MainViewModel(repo) as T
                }
            }
        }
        viewModel.addNewGasto(Gasto(1, "Comida", 12.00))
        viewModel.listGastos.observe(this) {
            it.forEach {
                Log.i("MainActivity", it.toString())
            }
        }
    }

    fun initBD() {
        db = this.let {
            AppDataBase.invoke(this)
        }
    }
}