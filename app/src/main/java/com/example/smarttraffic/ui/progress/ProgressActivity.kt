package com.example.smarttraffic.ui.progress

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R

class ProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        val btnAdvice = findViewById<TextView>(R.id.btnAdvice)
        val btnViewRanking = findViewById<TextView>(R.id.btnViewRanking)

        btnAdvice.setOnClickListener {
            Toast.makeText(this, "Đi ôn tập ngay", Toast.LENGTH_SHORT).show()
        }

        btnViewRanking.setOnClickListener {
            Toast.makeText(this, "Mở bảng xếp hạng", Toast.LENGTH_SHORT).show()
        }
    }
}