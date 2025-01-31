package com.example.bocadilloandroid

import android.content.Intent
import android.graphics.DashPathEffect
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login)
        val btnIrAotraPantalla = findViewById<Button>(R.id.btnLogin)

        btnIrAotraPantalla.setOnClickListener {
            val intent = Intent(this, DashBoardAlumno::class.java)
            startActivity(intent) // Iniciar la otra actividad
        }
    }
}