package com.codepath.lab6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.parks_menu_item -> {
                    supportActionBar?.title = getString(R.string.title_parks)
                    replaceFragment(ParksFragment())
                    true
                }
                R.id.campgrounds_menu_item -> {
                    supportActionBar?.title = getString(R.string.title_campgrounds)
                    replaceFragment(CampgroundFragment())
                    true
                }
                else -> false
            }
        }

        supportActionBar?.title = getString(R.string.title_parks)
        replaceFragment(ParksFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
