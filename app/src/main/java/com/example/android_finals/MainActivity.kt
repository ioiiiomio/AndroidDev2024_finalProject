package com.example.android_finals

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sample data for the ListView
        val items = listOf(
            Item(R.drawable.new_collection, "New Collection"),
            Item(R.drawable.best_sellers, "Best Sellers"),
            Item(R.drawable.new_arrivals, "New Arrivals"),
            Item(R.drawable.jewellery, "Jewellery"),
            Item(R.drawable.matching_sets, "Matching Sets")

        )

        // Set up the ListView and its adapter
        val listView: ListView = findViewById(R.id.listView)
        val adapter = ItemAdapter(this, items)
        listView.adapter = adapter
    }
}
