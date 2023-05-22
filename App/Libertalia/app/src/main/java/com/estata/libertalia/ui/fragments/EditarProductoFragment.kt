package com.estata.libertalia.ui.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.findNavController
import com.estata.libertalia.R
import com.estata.libertalia.data.modelo.Producto
import com.estata.libertalia.data.repositorio.FirebaseRepos

class EditarProductoFragment : Fragment() {
    private var producto : Producto? = null
    private val GALLERY_INTENT = 1
    lateinit var repos: FirebaseRepos
    var listaUrls: ArrayList<Uri> = ArrayList()

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            producto = it.getSerializable("producto") as Producto
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editar_producto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addImg(view)
        iniciar()
    }

    fun iniciar() {
        //Inicializacion de elementos de la vista
        val btnEditar: Button = requireView().findViewById(R.id.btnEditar)
        val edtNombre: EditText = requireView().findViewById(R.id.edtNombre)
        val edtDescripcion: EditText = requireView().findViewById(R.id.edtDescripcion)
        val edtCategorias: EditText = requireView().findViewById(R.id.edtCategorias)
        val edtPrecio: EditText = requireView().findViewById(R.id.edtPrecio)
        val edtTallas: EditText = requireView().findViewById(R.id.edtTallas)
        val edtColores: EditText = requireView().findViewById(R.id.edtColores)

        //Insertar valores en los campos
        edtNombre.setText(producto?.nombre)
        edtDescripcion.setText(producto?.descipcion)
        edtCategorias.setText(producto?.categorias.toString())
        edtPrecio.setText(producto?.precio.toString())
        edtTallas.setText(producto?.precio.toString())
        edtColores.setText(producto?.colores.toString())

        //Listener para cambiar los datos y regresar a la pantalla de admin
        btnEditar.setOnClickListener{
            //Combrueba si hay una o mas categorias
            var categorias  = ArrayList<String>()
            if (edtCategorias.text.toString().contains(",")) {
                categorias = edtCategorias.text.toString().split(",") as ArrayList<String>
            } else {
                categorias.add(edtCategorias.text.toString())
            }

            //Combrueba si hay una o mas tallas
            var tallas = ArrayList<String>()
            if (edtTallas.text.toString().contains(",")) {
                tallas = edtTallas.text.toString().split(",") as ArrayList<String>
            } else {
                tallas.add(edtTallas.text.toString())
            }

            //Combrueba si hay una o mas colores
            var colores  = ArrayList<String>()
            if (edtColores.text.toString().contains(",")) {
                colores = edtColores.text.toString().split(",") as ArrayList<String>
            } else {
                colores.add(edtColores.text.toString())
            }

            //Convierte el String en Double
            val precio = edtPrecio.text.toString().toDouble()

            repos = FirebaseRepos()
            repos.updateProducto(edtNombre.text.toString(), edtDescripcion.text.toString(), categorias, precio,
                tallas, colores, listaUrls, requireContext(), producto.id)

            view?.findNavController()?.navigate(R.id.adminFragment)
        }
    }*/

    fun addImg (view: View) {
        //Inicializacion de elemento de la vista
        val ivImagen: ImageView = view.findViewById(R.id.ivImagen)

        //Listener del icono de agregar imagen
        ivImagen.setOnClickListener{
            var intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*"
            startActivityForResult(intent, GALLERY_INTENT)

            //Añade las URLs de las imagenes a la lista
            val imgUri = intent?.data
            listaUrls.add(imgUri!!)
        }


    }
}