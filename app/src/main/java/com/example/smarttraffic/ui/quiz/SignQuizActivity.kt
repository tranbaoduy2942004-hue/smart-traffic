package com.example.smarttraffic.ui.quiz

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.google.android.material.button.MaterialButton

class SignQuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_quiz)

        findViewById<MaterialButton>(R.id.btnConfirm).setOnClickListener {
            Toast.makeText(this, "Đáp án đúng: Nguy hiểm khác", Toast.LENGTH_SHORT).show()
        }
    }
}