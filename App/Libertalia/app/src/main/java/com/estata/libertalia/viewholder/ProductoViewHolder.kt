package com.estata.libertalia.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.estata.libertalia.data.modelo.Producto
import com.estata.libertalia.databinding.ProductoAdminBinding

class ProductoViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ProductoAdminBinding.bind(view)

    fun bind (producto: Producto) {
        binding.tvNombre.text = producto.nombre
    }
}