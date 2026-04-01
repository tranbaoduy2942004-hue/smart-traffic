package com.example.smarttraffic.ui.quiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.google.android.material.button.MaterialButton

class QuizResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        findViewById<MaterialButton>(R.id.btnRetryWrong).setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }
}