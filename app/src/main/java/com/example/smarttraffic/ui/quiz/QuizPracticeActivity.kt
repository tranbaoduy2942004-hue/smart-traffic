package com.example.smarttraffic.ui.quiz

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R

class QuizPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_practice)

        // Xử lý nút Back
        findViewById<View>(R.id.btnBack)?.setOnClickListener {
            finish()
        }
    }
}