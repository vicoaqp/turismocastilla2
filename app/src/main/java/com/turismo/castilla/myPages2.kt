package com.turismo.castilla

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class myPages2(fB:FragmentActivity):FragmentStateAdapter(fB) {

    override fun getItemCount(): Int=3


    override fun createFragment(position: Int): Fragment {

        return when(position){
            0->{
                val f1=frgA()
                return f1
            }
            1->{
                val f2=frgB()
                return f2
            }
            else -> {
                val f3=frgC()
                return f3
            }
        }

    }

}