package com.estata.libertalia.data.modelo

data class Pedido(
    var id: String = "",
    var estado: String = "",
    var productos: Map<Producto, Int>,
    var precioTotal: Double = 0.0
)
