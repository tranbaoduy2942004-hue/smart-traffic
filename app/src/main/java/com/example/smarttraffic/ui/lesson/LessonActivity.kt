package com.example.smarttraffic.ui.lesson

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.home.HomeActivity
import com.example.smarttraffic.ui.profile.ProfileActivity
import com.example.smarttraffic.ui.quiz.QuizPracticeActivity
import com.example.smarttraffic.ui.search.SearchActivity

class LessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        // 1. Xử lý nút Back
        findViewById<View>(R.id.btnBack)?.setOnClickListener {
            finish()
        }

        // 2. Click vào bài học (Ví dụ bài 1)
        findViewById<LinearLayout>(R.id.itemRule1)?.setOnClickListener {
            startActivity(Intent(this, LessonDetailActivity::class.java))
        }

        // 3. Bottom Navigation Bar
        findViewById<View>(R.id.navHome)?.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        findViewById<View>(R.id.navStudy)?.setOnClickListener {
            // Đang ở trang bài học rồi
        }

        findViewById<View>(R.id.navQuiz)?.setOnClickListener {
            startActivity(Intent(this, QuizPracticeActivity::class.java))
        }

        findViewById<View>(R.id.navProfile)?.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}