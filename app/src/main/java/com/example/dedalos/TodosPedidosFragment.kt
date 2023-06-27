package com.example.dedalos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dedalos.databinding.FragmentBuscarBinding
import com.example.dedalos.databinding.FragmentTodosPedidosBinding


class TodosPedidosFragment : Fragment() {

    private lateinit var binding: FragmentTodosPedidosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodosPedidosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar o clique na imagem view 7
        binding.imageView29.setOnClickListener {
            // Navegar para o fragmento DetalheProdutoFragment
            findNavController().navigate(R.id.detalhePedidosFragment)

        }
    }
}