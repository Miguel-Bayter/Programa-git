package com.example.tugestionamiga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

/**
 * Adapter del RecyclerView para la pantalla de búsqueda.
 *
 * Responsabilidad:
 * - Pintar cada libro usando el layout `item_book.xml`.
 * - Mostrar estado (Disponible/No disponible).
 * - Ejecutar un callback cuando el usuario presiona "Ver Detalle".
 */
class BookAdapter(
    private val items: List<BookUiModel>,
    private val onDetailClick: () -> Unit
) : RecyclerView.Adapter<BookAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val author: TextView = itemView.findViewById(R.id.tvAuthor)
        val status: TextView = itemView.findViewById(R.id.tvStatus)
        val detail: MaterialButton = itemView.findViewById(R.id.btnDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.author.text = item.author

        // Se cambia el texto y el "badge" según disponibilidad.
        if (item.available) {
            holder.status.text = holder.itemView.context.getString(R.string.available)
            holder.status.setBackgroundResource(R.drawable.bg_badge_available)
            holder.status.setTextColor(holder.itemView.context.getColor(R.color.green_secondary))
        } else {
            holder.status.text = holder.itemView.context.getString(R.string.not_available)
            holder.status.setBackgroundResource(R.drawable.bg_badge_unavailable)
            holder.status.setTextColor(holder.itemView.context.getColor(R.color.red_help))
        }

        // Acción del botón "Ver Detalle".
        holder.detail.setOnClickListener { onDetailClick() }
    }

    override fun getItemCount(): Int = items.size
}
