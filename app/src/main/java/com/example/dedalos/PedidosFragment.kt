package com.example.dedalos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dedalos.databinding.FragmentPedidosBinding
import com.google.android.material.tabs.TabLayoutMediator

class PedidosFragment : Fragment() {
    private lateinit var binding: FragmentPedidosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPedidosBinding.inflate(inflater, container, false)

//        binding.imageView26.setOnClickListener {
//            // Voltar ao fragmento anterior
//            findNavController().popBackStack()
//        }

        val adapter = PedidosAdapter(childFragmentManager, lifecycle)
        binding.viewPager2.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Todos"
                1 -> tab.text = "Aguardando"
                2 -> tab.text = "Retirados"
                3 -> tab.text = "Cancelados"
            }
        }.attach()

        return binding.root


    }
}
