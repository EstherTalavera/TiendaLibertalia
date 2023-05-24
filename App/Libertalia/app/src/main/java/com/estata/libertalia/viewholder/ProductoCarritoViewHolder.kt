package com.estata.libertalia.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.estata.libertalia.data.modelo.Producto
import com.estata.libertalia.databinding.ProductoCarritoBinding

class ProductoCarritoViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ProductoCarritoBinding.bind(view)

    fun bind (producto: Producto) {
        binding.tvNombre.text = producto.nombre
        //binding.tvNum.text =
        binding.tvPrecioIndiv.text = producto.precio.toString()
        //binding.tvPrecioTotal.text =
    }
}