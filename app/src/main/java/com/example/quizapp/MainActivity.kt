package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitName.setOnClickListener {
            if(name.text.toString().isEmpty())
            {
                name.setError("Please enter name")
            }
            else{
                val intent = Intent(this, QuizQuestionActivity :: class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}