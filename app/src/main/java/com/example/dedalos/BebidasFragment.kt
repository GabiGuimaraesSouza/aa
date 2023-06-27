package com.example.dedalos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dedalos.databinding.FragmentAperitivosBinding
import com.example.dedalos.databinding.FragmentBebidasBinding


class BebidasFragment : Fragment() {

    private lateinit var binding: FragmentBebidasBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBebidasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar o clique no botão de login
        binding.imageView7.setOnClickListener {
            // Navegar para o fragmento CarrinhoFragment
            findNavController().navigate(R.id.detalheBebidasFragment)
        }

        // Configurar o clique na imagem view 6
        binding.imageView3.setOnClickListener {
            // Voltar ao fragmento anterior
            findNavController().popBackStack()
        }
    }
}