package com.example.dedalos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dedalos.databinding.FragmentLoginBinding
import com.example.dedalos.extensions.openActivity


class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onClick()
    }

    private fun onClick() {
        binding?.btnLogin?.setOnClickListener{
            requireActivity().openActivity<MainActivity>(finishWhenOpen = true)

        }
    }

}
