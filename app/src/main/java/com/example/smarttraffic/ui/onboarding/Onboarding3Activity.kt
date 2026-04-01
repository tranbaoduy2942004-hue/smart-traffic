package com.example.smarttraffic.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.auth.LoginActivity
import com.google.android.material.button.MaterialButton

class Onboarding3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_3)

        Log.d("Onboarding3", "Activity Created")

        // Tìm nút bằng ID chính xác trong XML
        val btnStart = findViewById<MaterialButton>(R.id.btnStart)
        val tvSkip = findViewById<View>(R.id.tvSkip)

        btnStart.setOnClickListener {
            Log.d("Onboarding3", "btnStart clicked")
            navigateToLogin()
        }

        tvSkip?.setOnClickListener {
            Log.d("Onboarding3", "tvSkip clicked")
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        try {
            val intent = Intent(this, LoginActivity::class.java)
            // Xóa sạch Stack để không quay lại được Onboarding
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            Log.d("Onboarding3", "Starting LoginActivity")
            finish()
        } catch (e: Exception) {
            Log.e("Onboarding3", "Navigation error: ${e.message}")
        }
    }
}