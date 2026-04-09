package com.example.smarttraffic.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.auth.LoginActivity
import com.example.smarttraffic.ui.home.HomeActivity
import com.example.smarttraffic.ui.progress.ProgressActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 1. Nút Back
        findViewById<View>(R.id.btnBack)?.setOnClickListener {
            finish()
        }

        // 2. Các mục menu
        findViewById<View>(R.id.itemProgress)?.setOnClickListener {
            startActivity(Intent(this, ProgressActivity::class.java))
        }

        findViewById<View>(R.id.itemLogout)?.setOnClickListener {
            showLogoutDialog()
        }

        // 3. Bottom Navigation Bar
        findViewById<View>(R.id.navHome)?.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
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