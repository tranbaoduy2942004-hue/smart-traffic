package com.example.smarttraffic.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.profile.ProfileSetupActivity
import com.google.android.material.button.MaterialButton

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Xử lý nút Back
        findViewById<View>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Nút Đăng ký -> Chuyển sang thiết lập hồ sơ
        findViewById<MaterialButton>(R.id.btnRegister).setOnClickListener {
            startActivity(Intent(this, ProfileSetupActivity::class.java))
            finish()
        }

        // Dòng chữ "Đăng nhập ngay" -> Quay lại trang Đăng nhập
        findViewById<TextView>(R.id.tvLogin).setOnClickListener {
            finish() // Đóng trang đăng ký để lộ trang đăng nhập bên dưới
        }
    }
}