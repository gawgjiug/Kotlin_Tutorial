package com.example.tutorial

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.tutorial.databinding.ActivityListViewAddDeleteBinding

class ListView_Add_DeleteActivity : AppCompatActivity() {
    var todo = mutableListOf<String>()
    lateinit var adapter: ArrayAdapter<String>
    lateinit var listView: ListView
    lateinit var editText: EditText
    lateinit var button: Button

    val binding by lazy { ActivityListViewAddDeleteBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        listView = findViewById(R.id.main_list)
        editText = findViewById(R.id.edit)
        button = findViewById(R.id.button)

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            todo
        )
        listView.adapter = adapter

        // 리스트뷰의 항목을 클릭하면 항목 제거 여부를 묻는 다이얼로그 띄우기
        listView.setOnItemClickListener { adpaterView, view, i, l ->
            AlertDialog.Builder(this)
                .setTitle("Remove TODO")
                .setPositiveButton("OK") { dialog, which ->
                    todo.removeAt(i)
                    adapter.notifyDataSetChanged()
                }
                .setNegativeButton("CANCEL", null)
                .create()
                .show()
        }

        // add 버튼 누르면 리스트뷰에 항목 추가
        button.setOnClickListener {
            todo.add(editText.text.toString())
            editText.text.clear()
            adapter.notifyDataSetChanged()
        }

        binding.btnToCustom.setOnClickListener {
            Log.d("ListView_Add_DeleteActivity", "버튼이 클릭되었습니다.MVC_Activity로 전환을 시도합니다.")
            val intent = Intent(this, MVC_Activity::class.java)
            startActivity(intent)
        }





    }
}