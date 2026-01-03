package com.example.tugestionamiga

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Pantalla de detalle del libro (maquetación).
 *
 * Función:
 * - Mostrar una ficha visual del libro: imagen, título, autor, género, estado y botones.
 * - En este proyecto no compra ni renta realmente; solo presenta la interfaz.
 */
class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        // Botón back del toolbar: regresa a la pantalla anterior.
        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            finish()
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        setupBottomNavigation(bottomNav, R.id.nav_search) { intent ->
            startActivity(intent)
        }
    }
}
