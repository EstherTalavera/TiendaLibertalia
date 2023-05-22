package com.estata.libertalia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estata.libertalia.R
import com.estata.libertalia.data.adapter.ProductoAdminAdapter
import com.estata.libertalia.data.adapter.ProductoCatalogoAdapter
import com.estata.libertalia.data.modelo.Producto
import com.estata.libertalia.data.repositorio.FirebaseRepos
import kotlinx.coroutines.launch


class CatalogoFragment : Fragment() {
    lateinit var repos: FirebaseRepos
    lateinit var recview: RecyclerView

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalogo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Mostrar action bar
        (requireActivity() as AppCompatActivity).supportActionBar?.show()

        //Añadir usuario
        repos = FirebaseRepos()
        repos.addUser(arrayListOf(), requireContext())

        iniciar(view)
    }

    fun iniciar(view: View) {
        //Inicializacion de elementos de la vista
        val busca: SearchView = view.findViewById(R.id.buscador)
        val ivCarrito: ImageView = view.findViewById(R.id.ivCarrito)
        recview = view.findViewById(R.id.rvCatalogo)

        //Listener para cambiar a la pantalla del carrito
        ivCarrito.setOnClickListener {
            view?.findNavController()?.navigate(R.id.carritoFragment)
        }

        //Recycler view
        var repo = FirebaseRepos()
        var prodList = arrayListOf<Producto>()

        recview.setHasFixedSize(true)
        recview.visibility = View.VISIBLE
        recview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        lifecycleScope.launch{
            prodList = repo.getAllProductos() as ArrayList<Producto>
            var adapter = ProductoCatalogoAdapter(prodList)

            recview.adapter = adapter
        }
    }
}