package com.estata.libertalia.data.repositorio

import android.content.Context
import android.widget.Toast
import com.estata.libertalia.data.modelo.Pedido
import com.estata.libertalia.data.modelo.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class FirebaseRepos {
    val dataBase = FirebaseFirestore.getInstance() //db
    val autentificacion = FirebaseAuth.getInstance() //aut
    val dataBaseStorage = FirebaseStorage.getInstance() //ds

    //Añadir usuario nuevo
    //Usuario
    var user = Usuario("", ArrayList<Pedido>())

    fun addUser(pedios: ArrayList<Pedido>, contexto: Context) {
        var id = getIdUsuario()
        user.id = id
        if (pedios.isNotEmpty()) {
            user.pedidos = pedios
        }

        dataBase.collection("usuarios").document(id).set(user).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(contexto, "Datos actualizados", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(contexto, "No se han actualizado los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Obtener id del usuario
    fun getIdUsuario(): String {
        var id = autentificacion.currentUser?.uid.toString()
        return id
    }
}