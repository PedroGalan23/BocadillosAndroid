package com.example.bocadilloandroid.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bocadilloandroid.DasBoardCocina
import com.example.bocadilloandroid.DashBoardAdmin
import com.example.bocadilloandroid.DashBoardAlumno
import com.example.bocadilloandroid.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userRole = intent.getStringExtra("USER_ROLE") ?: "alumno"

        val intent = when (userRole.lowercase()) {
            "alumno" -> Intent(this, DashBoardAlumno::class.java)
            "cocina" -> Intent(this, DasBoardCocina::class.java)
            "admin" -> Intent(this, DashBoardAdmin::class.java)
            else -> Intent(this, DashBoardAlumno::class.java) // Default
        }

        startActivity(intent)
        finish() // Cierra MainActivity para que no pueda volver atrás
    }
}
