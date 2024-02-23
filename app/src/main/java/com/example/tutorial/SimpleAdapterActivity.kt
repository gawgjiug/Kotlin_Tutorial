package com.example.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class SimpleAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_adapter)

        val listView = findViewById<ListView>(R.id.simple_Listview)
        val data: ArrayList<HashMap<String,String>> = ArrayList()
        var map : HashMap<String,String> = HashMap()
        map["제품명"] = "신라면"
        map["맵기 정도"] = "5단계"
        data.add(map)

        map = HashMap()
        map["제품명"] = "불닭 볶음면"
        map["맵기 정도"] = "9단계"
        data.add(map)

        map = HashMap()
        map["제품명"] = "안성탕면"
        map["맵기 정도"] = "1단계"
        data.add(map)

        val adapter = SimpleAdapter(
            this,
            data,
            android.R.layout.simple_list_item_2,
            arrayOf("제품명", "맵기 정도"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        listView.adapter = adapter
    }
}