package com.example.sqliteandroidroom.service

import com.example.sqliteandroidroom.Gasto
import com.example.sqliteandroidroom.dao.GastosDAO

interface Repository{

    suspend fun addGastoTask(gasto: Gasto)

    suspend fun getAllGastosTask(): List<Gasto>
}

class RepositoryImpl(val gastosDAO: GastosDAO): Repository{
    override suspend fun addGastoTask(gasto: Gasto) {
        gastosDAO.addGasto(gasto)
    }

    override suspend fun getAllGastosTask() = gastosDAO.getAllGastos()


}