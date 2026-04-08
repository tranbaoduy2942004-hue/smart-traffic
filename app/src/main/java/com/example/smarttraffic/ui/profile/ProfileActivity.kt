package com.example.smarttraffic.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.auth.LoginActivity
import com.example.smarttraffic.ui.favorite.FavoriteActivity
import com.example.smarttraffic.ui.home.HomeActivity
import com.example.smarttraffic.ui.lesson.LessonActivity
import com.example.smarttraffic.ui.progress.ProgressActivity
import com.example.smarttraffic.ui.quiz.QuizPracticeActivity
import com.example.smarttraffic.ui.settings.SettingsActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 1. Nút Back
        findViewById<View>(R.id.btnBack)?.setOnClickListener {
            finish()
        }

        // 2. Các mục menu (Sử dụng View để tránh ClassCastException)
        val itemProgress = findViewById<View>(R.id.itemProgress)
        val itemFavorite = findViewById<View>(R.id.itemFavorite)
        val itemSetting = findViewById<View>(R.id.itemSetting)
        val itemLogout = findViewById<View>(R.id.itemLogout)

        itemProgress?.setOnClickListener {
            startActivity(Intent(this, ProgressActivity::class.java))
        }

        itemFavorite?.setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }

        itemSetting?.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        itemLogout?.setOnClickListener {
            showLogoutDialog()
        }

        // 3. Bottom Navigation Bar
        findViewById<View>(R.id.navHome)?.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        findViewById<View>(R.id.navStudy)?.setOnClickListener {
            startActivity(Intent(this, LessonActivity::class.java))
        }

        findViewById<View>(R.id.navQuiz)?.setOnClickListener {
            startActivity(Intent(this, QuizPracticeActivity::class.java))
        }

        findViewById<View>(R.id.navProfile)?.setOnClickListener {
            // Đang ở trang hồ sơ rồi
        }
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(this)
            .setTitle("Đăng xuất?")
            .setMessage("Bạn có chắc chắn muốn đăng xuất khỏi ứng dụng An toàn Giao thông?")
            .setPositiveButton("Đăng xuất") { _, _ ->
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            .setNegativeButton("Hủy", null)
            .show()
    }
}