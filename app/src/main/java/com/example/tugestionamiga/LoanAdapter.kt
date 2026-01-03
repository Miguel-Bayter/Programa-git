package com.example.tugestionamiga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

/**
 * Adapter del RecyclerView para la pantalla "Mis Préstamos".
 *
 * Responsabilidad:
 * - Dibujar cada préstamo usando `item_loan.xml`.
 * - Mostrar el estado con un badge (Activo / Próximo a vencer).
 * - Ejecutar un callback cuando el usuario presiona el botón "Renovar".
 */
class LoanAdapter(
    private var items: List<LoanUiModel>,
    private val onRenewClick: (LoanUiModel) -> Unit
) : RecyclerView.Adapter<LoanAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cover: ImageView = itemView.findViewById(R.id.imgCover)
        val status: TextView = itemView.findViewById(R.id.tvStatus)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val author: TextView = itemView.findViewById(R.id.tvAuthor)
        val rentDate: TextView = itemView.findViewById(R.id.tvRentDate)
        val returnDate: TextView = itemView.findViewById(R.id.tvReturnDate)
        val renew: MaterialButton = itemView.findViewById(R.id.btnRenew)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_loan, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.author.text = item.author
        holder.rentDate.text = item.rentDate
        holder.returnDate.text = item.returnDate

        when (item.status) {
            LoanStatus.ACTIVE -> {
                holder.status.text = holder.itemView.context.getString(R.string.status_active)
                holder.status.setBackgroundResource(R.drawable.bg_badge_active)
                holder.status.setTextColor(holder.itemView.context.getColor(R.color.white))
            }
            LoanStatus.DUE_SOON -> {
                holder.status.text = holder.itemView.context.getString(R.string.status_due_soon)
                holder.status.setBackgroundResource(R.drawable.bg_badge_due_soon)
                holder.status.setTextColor(holder.itemView.context.getColor(R.color.text_primary))
            }
        }

        holder.renew.setOnClickListener { onRenewClick(item) }
    }

    override fun getItemCount(): Int = items.size

    fun submitList(newItems: List<LoanUiModel>) {
        // En un proyecto real se recomienda DiffUtil.
        // Para esta maqueta es suficiente actualizar la lista y refrescar todo.
        items = newItems
        notifyDataSetChanged()
    }
}
