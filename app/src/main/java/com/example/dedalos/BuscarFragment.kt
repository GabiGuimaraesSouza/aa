package com.example.dedalos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dedalos.databinding.FragmentBuscarBinding

class BuscarFragment : Fragment() {
    private lateinit var binding: FragmentBuscarBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuscarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar o clique na imagem view 7
        binding.imageView7.setOnClickListener {
            // Navegar para o fragmento DetalheProdutoFragment
            findNavController().navigate(R.id.detalheProdutoFragment)

        }
    }
}