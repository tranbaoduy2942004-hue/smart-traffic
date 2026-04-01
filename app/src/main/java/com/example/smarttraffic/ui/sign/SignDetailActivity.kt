package com.example.smarttraffic.ui.sign

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.quiz.SignQuizActivity
import com.google.android.material.button.MaterialButton

class SignDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_detail)

        findViewById<MaterialButton>(R.id.btnQuizSign).setOnClickListener {
            startActivity(Intent(this, SignQuizActivity::class.java))
        }
    }
}