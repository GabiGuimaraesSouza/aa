package com.example.dedalos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dedalos.databinding.FragmentRecarregarFinalBinding
import com.example.dedalos.databinding.FragmentRecarregarValorBinding


class RecarregarFinalFragment : Fragment() {
    private lateinit var binding: FragmentRecarregarFinalBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecarregarFinalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnLogin2.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

    }
}