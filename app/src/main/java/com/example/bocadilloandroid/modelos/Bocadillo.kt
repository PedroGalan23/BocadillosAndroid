package com.example.bocadilloandroid.modelos

data class Bocadillo(
    val id: Int,
    val nombre: String,
    val tipo: TipoBocadillo,
    val descripcion: String,
    val alergenos: String,
    val coste: Double,
    val logo: Int
)

enum class TipoBocadillo {
    FRIO, CALIENTE
}