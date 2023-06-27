package com.example.dedalos

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PedidosAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TodosPedidosFragment()
            1 -> AguardandoPedidosFragment()
            2 -> RetiradosPedidosFragment()
            3 -> CanceladoPedidosFragment()
            else -> Fragment()
        }
    }
}
