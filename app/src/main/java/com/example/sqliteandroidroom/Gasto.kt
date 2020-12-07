package com.example.sqliteandroidroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gastos")
data class Gasto(
    //@ColumnInfo(name = "nomes")
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var nome: String,
    var valor: Double
    )
