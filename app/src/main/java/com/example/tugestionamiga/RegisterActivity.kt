package com.example.tugestionamiga

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton

/**
 * Pantalla de registro (maquetación).
 *
 * Función:
 * - Mostrar el formulario visual para crear cuenta.
 * - Simular el flujo: al crear cuenta, se abre el menú principal.
 */
class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Botón back del toolbar: vuelve a la pantalla anterior.
        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            finish()
        }

        // Simulación de creación de cuenta: abre menú principal.
        findViewById<MaterialButton>(R.id.btnCreateAccount).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
