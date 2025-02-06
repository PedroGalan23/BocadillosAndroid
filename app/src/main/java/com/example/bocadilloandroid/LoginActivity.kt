package com.example.bocadilloandroid.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bocadilloandroid.R
import com.example.bocadilloandroid.UsuarioViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etRol = findViewById<EditText>(R.id.etRol)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        // Observa cambios en la autenticación
        usuarioViewModel.isLogged.observe(this) { isLoggedIn ->
            if (isLoggedIn) {
                val userRol = etRol.text.toString().trim()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("USER_ROLE", userRol)
                startActivity(intent)
                finish()
            }
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            usuarioViewModel.signInWithEmailAndPassword(email, password)
        }
    }
}
