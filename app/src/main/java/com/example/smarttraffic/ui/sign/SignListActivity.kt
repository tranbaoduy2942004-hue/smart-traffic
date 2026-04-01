package com.example.smarttraffic.ui.sign

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.home.HomeActivity
import com.example.smarttraffic.ui.lesson.LessonActivity
import com.example.smarttraffic.ui.profile.ProfileActivity
import com.example.smarttraffic.ui.quiz.QuizPracticeActivity

class SignListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_list)

        // 1. Nút Back - Quay lại trang Home
        findViewById<View>(R.id.btnBack)?.setOnClickListener {
            finish()
        }

        // 2. Click vào biển báo cụ thể
        findViewById<View>(R.id.itemNoLeftTurn)?.setOnClickListener {
            val intent = Intent(this, SignDetailActivity::class.java)
            startActivity(intent)
        }

        // 3. Thanh điều hướng dưới cùng (Bottom Navigation)
        findViewById<View>(R.id.navHome)?.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        findViewById<View>(R.id.navStudy)?.setOnClickListener {
            // Đang ở trang Học tập rồi
        }

        findViewById<View>(R.id.navQuiz)?.setOnClickListener {
            startActivity(Intent(this, QuizPracticeActivity::class.java))
        }

        findViewById<View>(R.id.navProfile)?.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}