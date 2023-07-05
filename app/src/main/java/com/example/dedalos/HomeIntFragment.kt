package com.example.dedalos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dedalos.databinding.FragmentHomeIntBinding
import androidx.navigation.fragment.findNavController

class HomeIntFragment : Fragment(), ItemCategoriaIntAdapter.OnItemClickListener {
    private lateinit var binding: FragmentHomeIntBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeIntBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCategoriaRecyclerView()

        binding.imageView8.setOnClickListener {
            findNavController().navigate(R.id.pedidosIntFragment)
        }
    }

    private fun setupCategoriaRecyclerView() {
        val itemCategoriaIntList = listOf(
            ItemCategoriaIntAdapter.ItemCategoriaInt("Ler Qr Code", R.drawable.ler_qr),
            ItemCategoriaIntAdapter.ItemCategoriaInt("Entradas", R.drawable.entradass),
            ItemCategoriaIntAdapter.ItemCategoriaInt("Pedidos", R.drawable.ic_pedidos)
        )

        val itemCategoriaIntAdapter = ItemCategoriaIntAdapter(itemCategoriaIntList, this)
        binding.recyclerView.apply {
            adapter = itemCategoriaIntAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    override fun onLerQrCodeClick() {
        findNavController().navigate(R.id.qrCodeIntFragment)
    }

    override fun onEntradasClick() {
        findNavController().navigate(R.id.entradasIntFragment)
    }

    override fun onPedidosClick() {
        findNavController().navigate(R.id.pedidosIntFragment)
    }
}
