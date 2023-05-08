package com.estata.libertalia.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.estata.libertalia.R

class AdminFragment : Fragment() {
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
        val btnNuevo: Button = view.findViewById(R.id.btnNuevo)

        //Cambiar a la pantalla
        btnNuevo.setOnClickListener{
            view?.findNavController()?.navigate(R.id.productoNuevoFragment)
        }
    }
}