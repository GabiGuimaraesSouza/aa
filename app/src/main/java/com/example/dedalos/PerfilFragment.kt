package com.example.dedalos

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dedalos.databinding.FragmentCarrinhoBinding
import com.example.dedalos.databinding.FragmentPerfilBinding


class PerfilFragment : Fragment() {

    private lateinit var binding: FragmentPerfilBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.imageView4.setOnClickListener {

            findNavController().navigate(R.id.homeFragment)
        }

        binding.imageView15.setOnClickListener {
            val intent = Intent(requireContext(), LogActivity::class.java)
            startActivity(intent)
        }

    }

}
