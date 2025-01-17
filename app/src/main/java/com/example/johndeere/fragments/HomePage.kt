package com.example.johndeere.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.johndeere.R
import com.example.johndeere.databinding.FragmentHomePageBinding

/*
Fragmento de la pantalla que se muestra al abrir la aplicación.
Permite iniciar sesión, registrar un nuevo usuario o acceder como invitado.
 */

class HomePage : Fragment() {
    private var _binding: FragmentHomePageBinding ? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val sharedPref = this.requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "")
        if (username != "") {
            view?.findNavController()?.navigate(R.id.action_homePage_frag_to_mainPage_frag)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val logIn = view.findViewById<Button>(R.id.logIn_button)
        val signUp = view.findViewById<Button>(R.id.signUp_button)
        val guest = view.findViewById<Button>(R.id.guest_button)

        val sharedPref = this.requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)

        val username = sharedPref.getString("username", "")
        if (username != "") {
            view.findNavController().navigate(R.id.action_homePage_frag_to_mainPage_frag)
        }

        logIn.setOnClickListener{
            view.findNavController().navigate(R.id.action_homePage_frag_to_logIn_frag)
        }

        signUp.setOnClickListener{
            view.findNavController().navigate(R.id.action_homePage_frag_to_signUp_frag)
        }

        guest.setOnClickListener{
            view.findNavController().navigate(R.id.action_homePage_frag_to_mainPage_frag)
        }
    }
}