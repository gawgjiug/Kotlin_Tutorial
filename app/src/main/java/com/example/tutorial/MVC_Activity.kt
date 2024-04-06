package com.example.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.tutorial.databinding.ActivityMvcBinding

//controller

class MVC_Activity : AppCompatActivity() {
    private lateinit var binding : ActivityMvcBinding

    var model = MVC_Model()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvc)

        binding.mvcActivity = this
    }


    fun clickNumber (i : Int){
        Toast.makeText(this,"$i 번을 클릭했습니다",Toast.LENGTH_SHORT).show()

        model.inputPassword(i)

        //View의 입력을 받아서 View를 업데이트함 , 동시에 inputPassword(Model) 메서드에 i 값을 전달하여 Model은 받은 데이터를 처리함.

        if (model.password.size == 4 && model.checkPassword()){
            //4자리 이상 비밀번호가 1234

            binding.passWordTxt.visibility = View.VISIBLE
        }
    }
}
