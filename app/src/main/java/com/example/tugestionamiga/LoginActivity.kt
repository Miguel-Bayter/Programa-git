package com.example.tugestionamiga

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

/**
 * Pantalla de inicio de sesión (maquetación).
 *
 * Función en este proyecto:
 * - Mostrar la UI del login.
 * - Simular el flujo: al presionar botones se navega a otras pantallas (sin validar credenciales).
 */
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Simulación de login: abre el menú principal.
        findViewById<MaterialButton>(R.id.btnLogin).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Acceso al registro.
        findViewById<MaterialButton>(R.id.btnRegister).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
