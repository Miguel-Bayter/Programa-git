package com.example.tugestionamiga

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

/**
 * Menú principal de la app (maquetación).
 *
 * Propósito:
 * - Mostrar accesos directos a las secciones principales (Buscar, Préstamos, Cuenta, Ayuda).
 * - Permitir una navegación sencilla entre pantallas usando Intents.
 *
 * Nota:
 * - Esta Activity NO implementa lógica real de negocio. Solo abre pantallas para visualizar maquetas.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ajuste visual para respetar el espacio de status bar / navigation bar (edge-to-edge).
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Botones grandes del menú (simulan accesos principales).
        findViewById<MaterialButton>(R.id.btnSearchBooks).setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
        findViewById<MaterialButton>(R.id.btnLoans).setOnClickListener {
            startActivity(Intent(this, LoansActivity::class.java))
        }
        findViewById<MaterialButton>(R.id.btnAccount).setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }
        findViewById<MaterialButton>(R.id.btnHelp).setOnClickListener {
            startActivity(Intent(this, HelpActivity::class.java))
        }

        // Bottom navigation: también permite abrir pantallas. (No mantiene estado complejo, es navegación simple.)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        setupBottomNavigation(bottomNav, R.id.nav_home) { intent ->
            startActivity(intent)
        }
    }
}