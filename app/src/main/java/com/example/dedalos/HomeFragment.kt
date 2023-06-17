package com.example.dedalos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dedalos.adapter.ItemCategoriaAdapter
import com.example.dedalos.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCategoriaRecyclerView()
        //setupPedidosRecyclerView()

        // binding.imageView13.setOnClickListener {
        //     onClick()
        // }
    }

    private fun setupCategoriaRecyclerView() {
        val itemCategoriaList = listOf(
            ItemCategoriaAdapter.ItemCategoria("Entradas", R.drawable.entradas),
            ItemCategoriaAdapter.ItemCategoria("Bebidas", R.drawable.bebidas),
            ItemCategoriaAdapter.ItemCategoria("Aperitivos", R.drawable.aperitivos),
            ItemCategoriaAdapter.ItemCategoria("Recarregar Cartão", R.drawable.recarregar)
        )

        val itemCategoriaAdapter = ItemCategoriaAdapter(itemCategoriaList)
        binding.recyclerView.apply {
            adapter = itemCategoriaAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }
}
