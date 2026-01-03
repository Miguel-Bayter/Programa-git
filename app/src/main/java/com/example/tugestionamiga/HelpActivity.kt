package com.example.tugestionamiga

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Pantalla de Ayuda (maquetación).
 *
 * Función:
 * - Mostrar texto informativo y datos de contacto.
 * - No realiza acciones reales; es solo presentación.
 */
class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        // Botón back del toolbar.
        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            finish()
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        setupBottomNavigation(bottomNav, R.id.nav_help) { intent ->
            startActivity(intent)
        }
    }
}
