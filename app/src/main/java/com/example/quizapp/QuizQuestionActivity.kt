package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_question.*
import kotlin.math.log

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

   private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Questions>? = null;
    private var mSelectedOptionPosition : Int = 0
    private var correctAnsCount : Int = 0
    private var submitted : Boolean = false
    private var userName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

            userName = intent.getStringExtra(Constants.User_Name)
        mQuestionList = Constants.getQuestionsList()

       setQuestion()

        ans1.setOnClickListener(this)
        ans2.setOnClickListener(this)
        ans3.setOnClickListener(this)
        ans4.setOnClickListener(this)

        submitAns.setOnClickListener(this)
    }

    private fun setQuestion(){

        var questions = mQuestionList!![mCurrentPosition-1] // or .get(mCurrentPosition-1)

        setDefaultOptions()

        if(mCurrentPosition == mQuestionList!!.size)
            submitAns.text = "Finish"
        else
            submitAns.text = "Submit"

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
        defaultOptions.add(3, ans4)

            for( option in defaultOptions){
                option.setTextColor(Color.parseColor("#7A8089"))
                option.typeface = Typeface.DEFAULT
                option.background = ContextCompat.getDrawable(this, R.drawable.optiontextbackground)

            }
    }

    override fun onClick(v: View?) {

       when(v?.id){

           R.id.ans1->{selectedOptionView(ans1, 1)}
           R.id.ans2->{selectedOptionView(ans2, 2)}
           R.id.ans3->{selectedOptionView(ans3, 3)}
           R.id.ans4->{selectedOptionView(ans4, 4)}
           R.id.submitAns -> {

               if (mSelectedOptionPosition == 0) {
                   mCurrentPosition++
                   Log.d("TAG", "mSelectedOptionPosition: $mSelectedOptionPosition ")

                   when {
                       mCurrentPosition <= mQuestionList!!.size -> {
                           setQuestion()
                         }
                       else -> {
                           val intent = Intent(this, FinalResult::class.java)
                           intent.putExtra(Constants.User_Name, userName)
                           intent.putExtra(Constants.Tatal_que, mQuestionList?.size)
                           intent.putExtra(Constants.Correct_Ans, correctAnsCount)
                           startActivity(intent)
                           finish()
                       }
                   }
               } else {
                   Log.d("TAG", "mSelectedOptionPosition: $mSelectedOptionPosition ")
                   val question = mQuestionList?.get(mCurrentPosition - 1)

                   if (question!!.correctAns != mSelectedOptionPosition) {
                       onClickSubmit(mSelectedOptionPosition, R.drawable.wrong_ans_bg)
                   } else {
                       correctAnsCount++
                   }

                   onClickSubmit(question!!.correctAns, R.drawable.correct_ans_bg)

                   if (mCurrentPosition == mQuestionList!!.size) {
                       submitAns.text = "Finish"
                       // Log.d("No of correct ans", "$correctAnsCount")
                   } else
                       submitAns.text = "Go To Next Question"
                   mSelectedOptionPosition = 0
               }

           }
       }

    }

    private fun selectedOptionView(tv : TextView, selectedoptionNo : Int){

        setDefaultOptions()
        mSelectedOptionPosition = selectedoptionNo
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selectedoptiontextbackground)

    }

    private fun onClickSubmit(ans : Int, drawableViw : Int){
        when(ans){
            1->{ans1.background = ContextCompat.getDrawable(this, drawableViw)}
            2->{ans2.background = ContextCompat.getDrawable(this, drawableViw)}
            3->{ans3.background = ContextCompat.getDrawable(this, drawableViw)}
            4->{ans4.background = ContextCompat.getDrawable(this, drawableViw)}

        }
    }
}