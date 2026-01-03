package com.example.tugestionamiga

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Pantalla "Mi Cuenta" (maquetación).
 *
 * Función:
 * - Mostrar información básica del usuario (avatar y nombre).
 * - Mostrar opciones como "Datos Personales" y "Configuración".
 *
 * Nota: no hay edición real de datos, solo UI.
 */
class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // Botón back del toolbar.
        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            finish()
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        setupBottomNavigation(bottomNav, R.id.nav_account) { intent ->
            startActivity(intent)
        }
    }
}
