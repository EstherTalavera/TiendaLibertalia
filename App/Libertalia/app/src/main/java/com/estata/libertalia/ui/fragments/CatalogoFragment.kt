package com.estata.libertalia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.estata.libertalia.R
import com.estata.libertalia.data.repositorio.FirebaseRepos


class CatalogoFragment : Fragment() {
    lateinit var repos: FirebaseRepos

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

        repos = FirebaseRepos()
        repos.addUser(arrayListOf(), requireContext())
    }
}