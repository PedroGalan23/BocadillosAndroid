package com.example.bocadilloandroid.modelos

import java.sql.Time
import java.util.Date

data class Pedido(
    val id: Int,
    val id_usuario: Int,
    val bocadillo: Bocadillo,
    val fecha: Date,
    val hora: Time,
    val estado:Boolean,
    val precio:Double
)