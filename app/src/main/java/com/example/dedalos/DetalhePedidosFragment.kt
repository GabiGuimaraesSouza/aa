package com.example.dedalos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dedalos.databinding.FragmentCarrinhoBinding
import com.example.dedalos.databinding.FragmentDetalhePedidosBinding

// Importe a classe R
import com.example.dedalos.R

class DetalhePedidosFragment : Fragment() {

    private lateinit var binding: FragmentDetalhePedidosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalhePedidosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView6.setOnClickListener {
            findNavController().navigate(R.id.pedidosFragment)
        }
    }
}
