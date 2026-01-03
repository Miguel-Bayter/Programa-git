package com.example.tugestionamiga

/**
 * Modelo de datos simple para la pantalla "Mis Préstamos".
 *
 * En esta entrega se usa con datos de ejemplo (mock) para visualizar el diseño.
 */
data class LoanUiModel(
    val title: String,
    val author: String,
    val rentDate: String,
    val returnDate: String,
    val status: LoanStatus
)

/**
 * Tipos de estado del préstamo.
 * - ACTIVE: préstamo vigente.
 * - DUE_SOON: préstamo próximo a vencer.
 */
enum class LoanStatus {
    ACTIVE,
    DUE_SOON
}
