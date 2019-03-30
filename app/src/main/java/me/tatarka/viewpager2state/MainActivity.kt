package me.tatarka.viewpager2state

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.StatefulAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager: ViewPager2 = findViewById(R.id.pager)!!

        Handler().post {
            pager.adapter = object : FragmentStateAdapter(supportFragmentManager) {
                override fun getItem(position: Int): Fragment = PageFragment()

                override fun getItemCount(): Int = 5
            }
        }
    }

    class PageFragment : Fragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.page, container, false)
        }
    }
}
