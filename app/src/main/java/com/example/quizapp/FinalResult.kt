package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_final_result.*

class FinalResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)
        image.setBackgroundResource(R.color.material_on_background_disabled)

         var user_Name = intent.getStringExtra(Constants.User_Name)
        userName.text = user_Name
        var correctAns = intent.getIntExtra(Constants.Correct_Ans, 0)
        var totalques = intent.getIntExtra(Constants.Tatal_que,0)


        score.text = "Your Score is $correctAns out of $totalques"

        finishApp.setOnClickListener { view->
            startActivity(Intent(this, MainActivity :: class.java))
        }

    }

    }