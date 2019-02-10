package com.tails.highthon.view.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tails.highthon.R
import com.tails.highthon.view.ui.fragment.HomeFragment
import com.tails.highthon.view.ui.fragment.ProfileFragment
import com.tails.highthon.view.ui.fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainFrameLayout, HomeFragment()).commitAllowingStateLoss()

        mainBottomNavigationView.setOnNavigationItemSelectedListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (it.itemId) {
                R.id.action_one -> {
                    transaction.replace(R.id.mainFrameLayout, HomeFragment()).commitAllowingStateLoss()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_two -> {
                    transaction.replace(R.id.mainFrameLayout, SearchFragment()).commitAllowingStateLoss()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_three -> {
                    transaction.replace(R.id.mainFrameLayout, ProfileFragment()).commitAllowingStateLoss()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }
}
