package com.estata.libertalia.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estata.libertalia.R
import com.estata.libertalia.data.adapter.ProductoAdminAdapter
import com.estata.libertalia.data.modelo.Producto
import com.estata.libertalia.data.repositorio.FirebaseRepos
import com.estata.libertalia.viewholder.ProductoViewHolder
import kotlinx.coroutines.launch

class AdminFragment : Fragment(), com.estata.libertalia.data.interfaces.OnItemClickListener {
    lateinit var recview: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciar(view)
    }

    private fun iniciar(view: View) {
        //Inicializacion de elementos de la vista
        recview = view.findViewById(R.id.rvProductos)
        val btnNuevo: Button = view.findViewById(R.id.btnNuevo)

        //Listener para cambiar a la pantalla
        btnNuevo.setOnClickListener{
            view?.findNavController()?.navigate(R.id.productoNuevoFragment)
        }

        //
        var repo = FirebaseRepos()
        var prodList = arrayListOf<Producto>()

        recview.setHasFixedSize(true)
        recview.visibility = View.VISIBLE
        recview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        lifecycleScope.launch{
            prodList = repo.getAllProductos() as ArrayList<Producto>
            var adapter = ProductoAdminAdapter(prodList, this@AdminFragment)

            recview.adapter = adapter
        }
    }

    override fun onItemClick(producto: Producto) {
        //borrar elemento. Llamar a firestore a traves del repo, que quite el elemento de la lista y la actuelize lista
    }
}