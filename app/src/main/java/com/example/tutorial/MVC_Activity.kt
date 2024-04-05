package com.example.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.tutorial.databinding.ActivityMvcBinding

class MVC_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityMvcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvc)

        binding.mvcActivity = this
    }


    fun clickNumber (i : Int){
        Toast.makeText(this,"$i 번을 클릭했습니다",Toast.LENGTH_SHORT).show()
    }
}
