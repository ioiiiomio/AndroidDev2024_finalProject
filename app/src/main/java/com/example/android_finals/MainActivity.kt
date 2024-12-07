package com.example.android_finals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainPageFragment = MainPageFragment.newInstance()
        val catalogFragment = CatalogFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, catalogFragment)
            .commit()
    }
}
