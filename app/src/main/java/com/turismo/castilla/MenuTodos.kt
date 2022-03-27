package com.turismo.castilla

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class MenuTodos: AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflador=menuInflater
        inflador.inflate(R.menu.main,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.act1->{
                menuActivity(Distritos::class.java)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun menuActivity(cls:Class<*>){
        val mactp= Intent(this,cls)
        startActivity(mactp)
    }


}