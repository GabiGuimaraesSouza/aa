package com.example.dedalos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.dedalos.databinding.FragmentRecarregarValorBinding
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.text.ParseException
import java.util.*

class RecarregarValorFragment : Fragment() {
    private lateinit var binding: FragmentRecarregarValorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecarregarValorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnLogin2.setOnClickListener {
            // Navegar para o fragmento CarrinhoFragment
            findNavController().navigate(R.id.recarregarFinalFragment)
        }

        binding.imageView6.setOnClickListener {
            // Voltar ao fragmento anterior
            findNavController().popBackStack()



        }
    }


}
