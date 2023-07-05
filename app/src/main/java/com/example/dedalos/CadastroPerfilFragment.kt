package com.example.dedalos

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dedalos.databinding.FragmentCadastroPerfilBinding
import com.example.dedalos.databinding.FragmentPerfilBinding


class CadastroPerfilFragment : Fragment() {

    private lateinit var binding: FragmentCadastroPerfilBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnLogin5.setOnClickListener {
            val intent = Intent(requireContext(), InternActivity::class.java)
            startActivity(intent)
        }


    }

}
