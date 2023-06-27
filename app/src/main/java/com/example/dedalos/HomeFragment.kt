package com.example.dedalos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dedalos.adapter.ItemCategoriaAdapter
import com.example.dedalos.databinding.FragmentHomeBinding
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(), ItemCategoriaAdapter.OnItemClickListener {
    private lateinit var binding: FragmentHomeBinding
    private var isSaldoVisible = false
    private lateinit var saldoContainer: RelativeLayout
    private lateinit var saldoTitle: TextView
    private lateinit var saldoValue: TextView
    private lateinit var eyeIcon: ImageView

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

        saldoContainer = binding.saldoContainer
        saldoTitle = binding.saldoTitle
        saldoValue = binding.saldoValue
        eyeIcon = binding.eyeIcon

        eyeIcon.setOnClickListener {
            isSaldoVisible = !isSaldoVisible
            updateSaldoVisibility()
        }

        // Inicialmente, ocultar o valor do saldo
        saldoValue.visibility = View.GONE
    }

    private fun setupCategoriaRecyclerView() {
        val itemCategoriaList = listOf(
            ItemCategoriaAdapter.ItemCategoria("Entradas", R.drawable.entradass),
            ItemCategoriaAdapter.ItemCategoria("Bebidas", R.drawable.bebidas),
            ItemCategoriaAdapter.ItemCategoria("Aperitivos", R.drawable.aperitivos),
            ItemCategoriaAdapter.ItemCategoria("Recarregar Cartão", R.drawable.recarregar)
        )

        val itemCategoriaAdapter = ItemCategoriaAdapter(itemCategoriaList, this)
        binding.recyclerView.apply {
            adapter = itemCategoriaAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.imageView8.setOnClickListener {
            findNavController().navigate(R.id.pedidosFragment)
        }
    }

    override fun onEntradasClick() {
        findNavController().navigate(R.id.entradasFragment)
    }

    override fun onBebidasClick() {
        findNavController().navigate(R.id.bebidasFragment)
    }

    override fun onAperitivosClick() {
        findNavController().navigate(R.id.aperitivosFragment)
    }

    override fun onRecarregarCartaoClick() {
        findNavController().navigate(R.id.recarregarFragment)
    }

    private fun updateSaldoVisibility() {
        if (isSaldoVisible) {
            saldoValue.visibility = View.VISIBLE
        } else {
            saldoValue.visibility = View.GONE
        }
    }
}
