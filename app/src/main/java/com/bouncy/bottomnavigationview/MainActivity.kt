package com.bouncy.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bouncy.bottomnavigationview.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
val firsFrag = first()
        val secondFragment = Second()
        val thirdFragment = Third()

        setCurrFrag(firsFrag)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> setCurrFrag(firsFrag)
                R.id.two -> setCurrFrag(secondFragment)
                R.id.three -> setCurrFrag(thirdFragment)

            }
            true
        }

        binding.bottomNavigationView.getOrCreateBadge(R.id.home).apply {
            number = 10
            isVisible = true
        }

    }

    private fun setCurrFrag(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment , fragment)
            commit()
        }
}