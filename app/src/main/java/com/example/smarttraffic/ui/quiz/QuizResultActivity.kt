package com.example.smarttraffic.ui.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R

class QuizResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        // 1. Nhận dữ liệu từ Intent
        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 40)
        val lawCorrect = intent.getIntExtra("law_correct", 0)
        val signCorrect = intent.getIntExtra("sign_correct", 0)

        // 2. Hiển thị điểm số tổng quát
        val tvFinalScore = findViewById<TextView>(R.id.tvFinalScore)
        val tvCorrectCount = findViewById<TextView>(R.id.tvCorrectCount)
        val tvWrongCount = findViewById<TextView>(R.id.tvWrongCount)
        val progressCircle = findViewById<ProgressBar>(R.id.resultProgressCircle)

        tvFinalScore.text = "$score/$total"
        tvCorrectCount.text = score.toString()
        tvWrongCount.text = (total - score).toString()
        
        val percentage = if (total > 0) (score * 100 / total) else 0
        progressCircle.progress = percentage

        // 3. Hiển thị chi tiết hạng mục
        findViewById<TextView>(R.id.tvLawScore).text = "$lawCorrect/20"
        findViewById<ProgressBar>(R.id.pbLaw).progress = (lawCorrect * 100 / 20)

        findViewById<TextView>(R.id.tvSignScore).text = "$signCorrect/10"
        findViewById<ProgressBar>(R.id.pbSign).progress = (signCorrect * 100 / 10)

        // 4. Các nút bấm
        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }
        
        findViewById<View>(R.id.btnRetryQuiz).setOnClickListener {
            finish() // Quay lại trang chọn đề
        }
    }
}