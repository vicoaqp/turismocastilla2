package com.turismo.castilla

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class myTurismo(fD:FragmentActivity):FragmentStateAdapter(fD) {

    override fun getItemCount(): Int=2


    override fun createFragment(position: Int): Fragment {

        return when(position){
            0->{
                val f1=FragDesTuri()
                return f1
            }
            else -> {
                val f3=FragLinkTuri()
                return f3
            }
        }
    }

}
