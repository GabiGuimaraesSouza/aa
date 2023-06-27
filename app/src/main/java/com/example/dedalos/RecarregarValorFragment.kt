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
            val enteredValue = binding.editTextValor.text.toString()

            val parsedValue = parseCurrency(enteredValue)
            if (parsedValue != null) {
                if (parsedValue <= BigDecimal("10000.00")) {
                    val formattedValue = formatCurrency(parsedValue)
                    Toast.makeText(requireContext(), "Valor formatado: $formattedValue", Toast.LENGTH_SHORT).show()
                    // Continuar com a ação desejada
                    findNavController().navigate(R.id.recarregarFinalFragment)
                } else {
                    Toast.makeText(requireContext(), "O valor máximo permitido é R$ 10.000,00", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Digite um valor válido", Toast.LENGTH_SHORT).show()
            }
        }

        binding.imageView6.setOnClickListener {
            // Voltar ao fragmento anterior
            findNavController().popBackStack()
        }
    }

    private fun parseCurrency(value: String): BigDecimal? {
        val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault()) as DecimalFormat
        val symbols = DecimalFormatSymbols.getInstance()
        symbols.groupingSeparator = '.'
        symbols.decimalSeparator = ','
        numberFormat.decimalFormatSymbols = symbols
        numberFormat.isParseBigDecimal = true

        return try {
            val parsedValue = numberFormat.parse(value)
            parsedValue as? BigDecimal
        } catch (e: ParseException) {
            null
        }
    }

    private fun formatCurrency(value: BigDecimal): String {
        val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault()) as DecimalFormat
        val symbols = DecimalFormatSymbols.getInstance()
        symbols.groupingSeparator = '.'
        symbols.decimalSeparator = ','
        numberFormat.decimalFormatSymbols = symbols
        numberFormat.maximumFractionDigits = 4

        return numberFormat.format(value)
    }
}
