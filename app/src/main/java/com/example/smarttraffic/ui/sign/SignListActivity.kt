package com.example.smarttraffic.ui.sign

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.home.HomeActivity
import com.example.smarttraffic.ui.profile.ProfileActivity
import com.example.smarttraffic.ui.quiz.QuizPracticeActivity

class SignListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_list)

        findViewById<View>(R.id.btnBack)?.setOnClickListener { finish() }

        // Truyền ID nhóm tương ứng với Database (Ví dụ: 1-Cấm, 2-Nguy hiểm, 3-Hiệu lệnh, 4-Chỉ dẫn, 5-Phụ)
        findViewById<View>(R.id.groupProhibition)?.setOnClickListener { openCategory(1, "Biển báo cấm") }
        findViewById<View>(R.id.groupDanger)?.setOnClickListener { openCategory(2, "Biển báo nguy hiểm") }
        findViewById<View>(R.id.groupMandatory)?.setOnClickListener { openCategory(3, "Biển hiệu lệnh") }
        findViewById<View>(R.id.groupInformation)?.setOnClickListener { openCategory(4, "Biển chỉ dẫn") }
        findViewById<View>(R.id.groupAdditional)?.setOnClickListener { openCategory(5, "Biển phụ") }

        setupBottomNav()
    }

    private fun openCategory(id: Int, title: String) {
        val intent = Intent(this, SignCategoryActivity::class.java)
        intent.putExtra("category_id", id)
        intent.putExtra("category_title", title)
        startActivity(intent)
    }

    private fun setupBottomNav() {
        findViewById<View>(R.id.navHome)?.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        findViewById<View>(R.id.navQuiz)?.setOnClickListener {
            startActivity(Intent(this, QuizPracticeActivity::class.java))
        }
        findViewById<View>(R.id.navProfile)?.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}