package com.estata.libertalia.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.estata.libertalia.R
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Matcher
import java.util.regex.Pattern

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciar(view)

        //Ocultar action bar
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    private fun iniciar(view: View) {
        //Inicializacion de elementos de la vista
        val edtEmail: EditText = view.findViewById(R.id.edtGmail)
        val edtConteaseña: EditText = view.findViewById(R.id.edtContraseña)
        val btnRegistrar: Button = view.findViewById(R.id.btnRegistrar)
        val btnLogear: Button = view.findViewById(R.id.btnLogin)

        val email = edtEmail.text
        val contraseña = edtConteaseña.text

        //Registro
        btnRegistrar.setOnClickListener{
            if (email.isNotEmpty() && contraseña.isNotEmpty()) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.toString(), contraseña.toString()).addOnCompleteListener{
                        if (it.isSuccessful) {
                            changeFragment(R.id.catalogoFragment)
                        } else {
                            if(contraseña.toString().length <6) {
                                showAlertPassword()
                            }
                            if (!validarEmail(email.toString())) {
                                showAlertEmail()
                            }
                        }
                    }.addOnFailureListener {
                        showAlertRepeat()
                    }

            } else {
                showAlertNotEntry()
            }
        }

        //Loguin
        btnLogear.setOnClickListener{
            if (email.isNotEmpty() && contraseña.isNotEmpty()) {
                if (email.toString() == "libertalia@gmail.com" && contraseña.toString() == "libertalia") {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email.toString(), contraseña.toString()).addOnCompleteListener {
                        if (it.isSuccessful) {
                            changeFragment(R.id.adminFragment)
                        } else {
                            showAlertEntryFailed()
                        }
                    }
                } else {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email.toString(), contraseña.toString()).addOnCompleteListener {
                        if (it.isSuccessful) {
                            changeFragment(R.id.catalogoFragment)
                        } else {
                            showAlertEntryFailed()
                        }
                    }
                }
            } else {
                showAlertNotEntry()
            }
        }
    }

    //Cambiar fragmento
    fun changeFragment(direccion: Int) {
        view?.findNavController()?.navigate(direccion)
    }

    //Validar email
    private fun validarEmail(texto: String): Boolean {
        val patern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
        var comparator: Matcher = patern.matcher(texto)
        return comparator.find()
    }

    //Error en el email
    fun showAlertEmail() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("El email debe de seguir el formato 'correo@gmail.com'")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    //Error en la contraseña
    fun showAlertPassword() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("La contraseña debe de tener más de 6 caracteres")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    //Error si algun campo esta vacio
    fun showAlertNotEntry() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("Uno de los campos esta vacio")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    //Error si el usuario ya esta registrado e intenta registrarse de nuevo
    fun showAlertRepeat() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("Este correo ya esta registrado")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    //Error al auntentificar
    fun showAlertEntryFailed() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("La contraseña o el email no esta correcto")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}