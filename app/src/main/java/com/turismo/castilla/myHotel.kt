package com.turismo.castilla

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class myHotel(fE:FragmentActivity):FragmentStateAdapter(fE) {
    override fun getItemCount(): Int=3

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0->{
                val f1=FragDesHotel()
                return f1
            }
            1->{
                val f2=FragFotosHotel()
                return f2
            }
            else -> {
                val f3=FragLinkHotel()
                return f3
            }
        }

    }


}