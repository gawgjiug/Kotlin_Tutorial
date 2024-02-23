package com.example.tutorial

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listView = findViewById<ListView>(R.id.main_list)
        val data = resources.getStringArray(R.array.job)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            data
        )
        listView.adapter = adapter


        val intent = Intent(this,SimpleAdapterActivity::class.java)
        binding.btnSimple.setOnClickListener { startActivity(intent) }

    }
}
