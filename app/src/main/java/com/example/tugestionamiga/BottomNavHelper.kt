package com.example.tugestionamiga

import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Configura la navegación inferior (BottomNavigationView) de forma consistente en todas las pantallas.
 */
fun setupBottomNavigation(
    bottomNav: BottomNavigationView,
    selectedItemId: Int,
    navigateTo: (Intent) -> Unit
) {
    bottomNav.selectedItemId = selectedItemId

    bottomNav.setOnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                if (selectedItemId == R.id.nav_home) return@setOnItemSelectedListener true
                navigateTo(Intent(bottomNav.context, MainActivity::class.java))
                true
            }
            R.id.nav_search -> {
                if (selectedItemId == R.id.nav_search) return@setOnItemSelectedListener true
                navigateTo(Intent(bottomNav.context, SearchActivity::class.java))
                true
            }
            R.id.nav_loans -> {
                if (selectedItemId == R.id.nav_loans) return@setOnItemSelectedListener true
                navigateTo(Intent(bottomNav.context, LoansActivity::class.java))
                true
            }
            R.id.nav_account -> {
                if (selectedItemId == R.id.nav_account) return@setOnItemSelectedListener true
                navigateTo(Intent(bottomNav.context, AccountActivity::class.java))
                true
            }
            R.id.nav_help -> {
                if (selectedItemId == R.id.nav_help) return@setOnItemSelectedListener true
                navigateTo(Intent(bottomNav.context, HelpActivity::class.java))
                true
            }
            else -> false
        }
    }
}
