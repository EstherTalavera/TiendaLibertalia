package com.estata.libertalia.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.estata.libertalia.R

class ContactoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciar(view)
    }

    private fun iniciar(view: View) {
        //Inicializacion de elementos de la vista
        val btnCorreo: TextView = view.findViewById(R.id.btnCorreo)

        //Mandar un correo
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, "libertalia@gmail.com") //Destinatario
            putExtra(Intent.EXTRA_SUBJECT, "Comision") //Asunto
        }

        //Listener para mandar el correo
        btnCorreo.setOnClickListener {
            startActivity(intent)
        }
    }





}