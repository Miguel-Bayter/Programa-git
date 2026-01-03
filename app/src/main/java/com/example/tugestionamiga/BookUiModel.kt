package com.example.tugestionamiga

/**
 * Modelo de datos simple para mostrar libros en la maqueta.
 *
 * En este proyecto se usa con datos de ejemplo (mock) para llenar el RecyclerView de búsqueda.
 */
data class BookUiModel(
    val title: String,
    val author: String,
    val available: Boolean
)
