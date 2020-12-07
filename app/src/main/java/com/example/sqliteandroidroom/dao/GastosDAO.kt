package com.example.sqliteandroidroom.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.sqliteandroidroom.Gasto

interface GastosDAO {

    @Insert
    suspend fun addGasto(gasto: Gasto)

    @Query("SELECT * FROM gastos")
    suspend fun getAllGastos(): List<Gasto>


}