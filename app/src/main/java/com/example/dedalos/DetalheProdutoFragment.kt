package com.example.dedalos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dedalos.databinding.FragmentBuscarBinding
import com.example.dedalos.databinding.FragmentDetalheProdutoBinding


class DetalheProdutoFragment : Fragment() {
    private lateinit var binding: FragmentDetalheProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalheProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar o clique no botão de login
        binding.btnLogin2.setOnClickListener {
            // Navegar para o fragmento CarrinhoFragment
            findNavController().navigate(R.id.aperitivoSucessoFragment)
        }

        // Configurar o clique na imagem view 6
        binding.imageView6.setOnClickListener {
            // Voltar ao fragmento anterior
            findNavController().popBackStack()
        }
    }
}