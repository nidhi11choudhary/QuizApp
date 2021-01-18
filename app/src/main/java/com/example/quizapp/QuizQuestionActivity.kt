package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*
import kotlin.math.log

class QuizQuestionActivity : AppCompatActivity() {

   private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Questions>? = null;
    private var mSelectedOptionPosition : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mQuestionList = Constants.getQuestionsList()
        setQuestion()
    }

    private fun setQuestion(){
        mCurrentPosition = 1
        var questions = mQuestionList!![mCurrentPosition-1] // or .get(mCurrentPosition-1)

        progress.progress = mCurrentPosition
        progressTv.text = "$mCurrentPosition" + "/" + progress.max

        questionTv.text = questions!!.Questions
        ans1.text = "A : " + questions.option1
        ans2.text = "B : " + questions.option2
        ans3.text = "C : " + questions.option3
        ans3.text = "C : " + questions.option3
        ans4.text = "D : " + questions.option4
    }

    private fun setDefaultOptions(){
        var defaultOptions = ArrayList<TextView>()
        defaultOptions.add(0, ans1)
        defaultOptions.add(1, ans2)
        defaultOptions.add(2, ans3)
        defaultOptions.add(3, ans1)

            for( option in defaultOptions){
                option.setTextColor(Color.parseColor(R.color.textColor2.toString()))
               // option.setTextColor(Color.parseColor("#7A8089")
                option.typeface = Typeface.DEFAULT
                option.background = ContextCompat.getDrawable(this, R.drawable.optiontextbackground)

            }
    }
}