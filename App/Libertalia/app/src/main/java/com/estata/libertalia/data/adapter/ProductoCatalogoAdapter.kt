package com.estata.libertalia.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estata.libertalia.R
import com.estata.libertalia.data.modelo.Producto
import com.estata.libertalia.viewholder.ProductoCatalogoViewHolder

class ProductoCatalogoAdapter(private var productoList: List<Producto>): RecyclerView.Adapter<ProductoCatalogoViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoCatalogoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductoCatalogoViewHolder(layoutInflater.inflate(R.layout.producto_catalogo, parent, false))
    }

    override fun onBindViewHolder(holder: ProductoCatalogoViewHolder, position: Int) {
        val item = productoList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = productoList.size

    fun updateData(dataList: List<Producto>) {
        this.productoList = dataList
        notifyDataSetChanged()
    }
}