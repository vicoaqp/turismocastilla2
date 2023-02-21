import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.turismo.castilla.*

class myPages(fA:FragmentActivity):FragmentStateAdapter(fA) {
    override fun getItemCount(): Int=2

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0->{
                val f1=frgA()
                return f1
            }
            //1->{
              //  val f2=frgB()
                //return f2
            //}
            else -> {
                val f2=frgD()
                return f2
            }
        }


    }

}