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

        // 1. Nút Back
        findViewById<View>(R.id.btnBack)?.setOnClickListener {
            finish()
        }

        // 2. Click vào các Nhóm biển báo (Đảm bảo ID khớp XML)
        findViewById<View>(R.id.groupProhibition)?.setOnClickListener {
            openCategory("CAM", "Biển báo cấm")
        }

        findViewById<View>(R.id.groupDanger)?.setOnClickListener {
            openCategory("NGUY_HIEM", "Biển báo nguy hiểm")
        }

        findViewById<View>(R.id.groupMandatory)?.setOnClickListener {
            openCategory("HIEU_LENH", "Biển hiệu lệnh")
        }

        findViewById<View>(R.id.groupInformation)?.setOnClickListener {
            openCategory("CHI_DAN", "Biển chỉ dẫn")
        }

        findViewById<View>(R.id.groupAdditional)?.setOnClickListener {
            openCategory("BIEN_PHU", "Biển phụ")
        }

        // 3. Bottom Navigation
        findViewById<View>(R.id.navHome)?.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        findViewById<View>(R.id.navQuiz)?.setOnClickListener {
            startActivity(Intent(this, QuizPracticeActivity::class.java))
        }

        findViewById<View>(R.id.navProfile)?.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    private fun openCategory(type: String, title: String) {
        val intent = Intent(this, SignCategoryActivity::class.java)
        intent.putExtra("category_type", type)
        intent.putExtra("category_title", title)
        startActivity(intent)
    }
}