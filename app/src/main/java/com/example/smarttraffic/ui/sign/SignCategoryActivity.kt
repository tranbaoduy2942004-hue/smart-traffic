package com.example.smarttraffic.ui.sign

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.home.HomeActivity
import com.example.smarttraffic.ui.profile.ProfileActivity
import com.example.smarttraffic.ui.quiz.QuizPracticeActivity

class SignCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_category)

        // 1. Hiển thị Tiêu đề Nhóm
        val title = intent.getStringExtra("category_title") ?: "Danh sách biển báo"
        findViewById<TextView>(R.id.tvCategoryTitle).text = title

        // 2. Nút Back
        findViewById<View>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // 3. Click vào từng biển báo (Ví dụ Item 1 & 2)
        findViewById<View>(R.id.itemSign1).setOnClickListener {
            val intent = Intent(this, SignDetailActivity::class.java)
            intent.putExtra("sign_id", 1) // Ví dụ ID
            startActivity(intent)
        }

        findViewById<View>(R.id.itemSign2).setOnClickListener {
            val intent = Intent(this, SignDetailActivity::class.java)
            intent.putExtra("sign_id", 2)
            startActivity(intent)
        }

        // 4. Bottom Navigation Bar
        findViewById<View>(R.id.navHome).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        findViewById<View>(R.id.navStudy).setOnClickListener {
            val intent = Intent(this, SignListActivity::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<View>(R.id.navQuiz).setOnClickListener {
            startActivity(Intent(this, QuizPracticeActivity::class.java))
        }

        findViewById<View>(R.id.navProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}