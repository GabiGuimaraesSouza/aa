package com.example.dedalos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dedalos.databinding.FragmentRecarregarBinding
import com.example.dedalos.databinding.FragmentTodosPedidosBinding


class RecarregarFragment : Fragment() {

    private lateinit var binding: FragmentRecarregarBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecarregarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar o clique na imagem view 7
        binding.imageView18.setOnClickListener {
            // Navegar para o fragmento DetalheProdutoFragment
            findNavController().navigate(R.id.recarregarValorFragment)

        }

        binding.imageView17.setOnClickListener {
            // Navegar para o fragmento DetalheProdutoFragment
            findNavController().navigate(R.id.recarregarValorFragment)

        }

        binding.imageView4.setOnClickListener {
            // Voltar ao fragmento anterior
            findNavController().popBackStack()
        }

    }
}