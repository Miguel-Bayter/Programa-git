package com.example.tugestionamiga

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Pantalla de búsqueda (maquetación).
 *
 * Nota importante:
 * - El archivo XML se llama `fragment_search.xml`, pero aquí se usa como contenido de una Activity
 *   solo para visualizar la maqueta (sin Navigation Component).
 *
 * Qué hace:
 * - Configura un RecyclerView con una lista de libros de ejemplo.
 * - Al tocar "Ver Detalle" abre la pantalla de detalle.
 */
class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_search)

        // Toolbar con back: cierra la pantalla.
        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            finish()
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        setupBottomNavigation(bottomNav, R.id.nav_search) { intent ->
            startActivity(intent)
        }

        // Configuración básica del RecyclerView.
        val rv = findViewById<RecyclerView>(R.id.rvBooks)
        rv.layoutManager = LinearLayoutManager(this)

        // Datos "mock" (de ejemplo) para que la lista se vea en ejecución.
        val items = listOf(
            BookUiModel(
                title = "El Gran Viaje",
                author = "Autor: A. Perez",
                available = true
            ),
            BookUiModel(
                title = "Historia Secreta",
                author = "Autor: L. Gómez",
                available = true
            )
        )

        // Adapter: cuando el usuario presiona Ver Detalle, abre la pantalla de detalle.
        rv.adapter = BookAdapter(items) {
            startActivity(Intent(this, BookDetailActivity::class.java))
        }
    }
}
