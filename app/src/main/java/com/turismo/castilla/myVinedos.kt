package com.turismo.castilla

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class myVinedos(fF:FragmentActivity):FragmentStateAdapter(fF) {
    override fun getItemCount(): Int=2

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0->{
                val f1=FragDesVinedos()
                return f1
            }

            else -> {
                val f3=FragLinkVinedos()
                return f3
            }
        }

    }


}