package com.example.smarttraffic.ui.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.home.HomeActivity
import com.example.smarttraffic.ui.profile.ProfileActivity

class QuizPracticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_practice)

        val layoutTopic = findViewById<View>(R.id.layoutTopicList)
        val layoutExam = findViewById<View>(R.id.layoutExamList)
        val tvTabTopic = findViewById<TextView>(R.id.tvTabTopic)
        val tvTabExam = findViewById<TextView>(R.id.tvTabExam)
        val indicatorTopic = findViewById<View>(R.id.indicatorTopic)
        val indicatorExam = findViewById<View>(R.id.indicatorExam)

        // 1. Xử lý chuyển Tab
        findViewById<View>(R.id.tabTopic).setOnClickListener {
            layoutTopic.visibility = View.VISIBLE
            layoutExam.visibility = View.GONE
            tvTabTopic.setTextColor(getColor(R.id.navQuiz)) // Màu xanh active
            tvTabExam.setTextColor(getColor(android.R.color.darker_gray))
            indicatorTopic.visibility = View.VISIBLE
            indicatorExam.visibility = View.INVISIBLE
        }

        findViewById<View>(R.id.tabExam).setOnClickListener {
            layoutTopic.visibility = View.GONE
            layoutExam.visibility = View.VISIBLE
            tvTabExam.setTextColor(getColor(R.id.navQuiz))
            tvTabTopic.setTextColor(getColor(android.R.color.darker_gray))
            indicatorTopic.visibility = View.INVISIBLE
            indicatorExam.visibility = View.VISIBLE
        }

        // 2. Mở làm Quiz theo chủ đề (Ví dụ)
        findViewById<View>(R.id.cardTopicLaw).setOnClickListener {
            startActivity(Intent(this, SignQuizActivity::class.java))
        }

        // 3. Mở làm Đề thi thật (Ví dụ bộ đề 1)
        findViewById<View>(R.id.cardExamSet1).setOnClickListener {
            startActivity(Intent(this, SignQuizActivity::class.java))
        }

        // 4. Hệ thống điều hướng
        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }
        
        findViewById<View>(R.id.navHome).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        
        findViewById<View>(R.id.navProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}