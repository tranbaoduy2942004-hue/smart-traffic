package com.example.smarttraffic.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.auth.LoginActivity
import com.example.smarttraffic.ui.favorite.FavoriteActivity
import com.example.smarttraffic.ui.progress.ProgressActivity
import com.example.smarttraffic.ui.settings.SettingsActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val itemProgress = findViewById<LinearLayout>(R.id.itemProgress)
        val itemFavorite = findViewById<LinearLayout>(R.id.itemFavorite)
        val itemSetting = findViewById<LinearLayout>(R.id.itemSetting)
        val itemLogout = findViewById<LinearLayout>(R.id.itemLogout)

        itemProgress.setOnClickListener {
            startActivity(Intent(this, ProgressActivity::class.java))
        }

        itemFavorite.setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }

        itemSetting.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        itemLogout.setOnClickListener {
            showLogoutDialog()
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