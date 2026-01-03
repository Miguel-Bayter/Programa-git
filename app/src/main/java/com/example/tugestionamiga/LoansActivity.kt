package com.example.tugestionamiga

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

/**
 * Pantalla de "Mis Préstamos".
 *
 * Qué se busca con esta pantalla:
 * - Mostrar una lista de préstamos con información (título, autor, fechas, estado).
 * - Permitir alternar entre "Activos" e "Historial" (solo visual, con datos de ejemplo).
 * - Mantener el Bottom Navigation para parecerse al mock.
 */
class LoansActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loans)

        // Toolbar con back: volver a la pantalla anterior.
        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            finish()
        }

        // Bottom navigation: se deja seleccionado en "Préstamos".
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        setupBottomNavigation(bottomNav, R.id.nav_loans) { intent ->
            startActivity(intent)
        }

        // Listas "mock" (de ejemplo) para ver el diseño sin backend.
        val activeList = listOf(
            LoanUiModel(
                title = "El Gran Viaje",
                author = "Autor: A. Pérez",
                rentDate = "Fecha de renta: 24 Abr 2024",
                returnDate = "Fecha de devolución: 1 May 2024",
                status = LoanStatus.ACTIVE
            ),
            LoanUiModel(
                title = "Historia Secreta",
                author = "Autor: L. Gómez",
                rentDate = "Fecha de renta: 20 Abr 2024",
                returnDate = "Fecha de devolución: 30 Abr 2024",
                status = LoanStatus.DUE_SOON
            )
        )

        val historyList = listOf(
            LoanUiModel(
                title = "Cuentos del Bosque",
                author = "Autor: M. Rojas",
                rentDate = "Fecha de renta: 02 Mar 2024",
                returnDate = "Fecha de devolución: 10 Mar 2024",
                status = LoanStatus.ACTIVE
            )
        )

        // RecyclerView: lista de préstamos.
        val rv = findViewById<RecyclerView>(R.id.rvLoans)
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = LoanAdapter(activeList) {
            // Navegación simple: "Renovar" no hace lógica real, solo abre detalle para visualizar.
            startActivity(Intent(this, BookDetailActivity::class.java))
        }
        rv.adapter = adapter

        // Selector "Activos / Historial".
        val toggle = findViewById<MaterialButtonToggleGroup>(R.id.toggleLoans)
        val btnActive = findViewById<MaterialButton>(R.id.btnActive)
        val btnHistory = findViewById<MaterialButton>(R.id.btnHistory)

        // Por defecto se muestran los préstamos activos.
        toggle.check(btnActive.id)
        btnActive.isChecked = true

        // Cuando el usuario cambia el selector, se reemplaza la lista en el adapter.
        toggle.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (!isChecked) return@addOnButtonCheckedListener
            when (checkedId) {
                btnActive.id -> adapter.submitList(activeList)
                btnHistory.id -> adapter.submitList(historyList)
            }
        }
    }
}
