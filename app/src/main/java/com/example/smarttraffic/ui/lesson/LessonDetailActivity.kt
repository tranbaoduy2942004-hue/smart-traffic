package com.example.smarttraffic.ui.lesson

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.google.android.material.button.MaterialButton

class LessonDetailActivity : AppCompatActivity() {

    private var currentStep = 0
    private val totalSteps = 3 // Giả định mỗi chủ đề có 3 bài học chi tiết

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_detail)

        val topicId = intent.getIntExtra("topic_id", 1)
        updateUI(topicId)

        findViewById<View>(R.id.btnBack).setOnClickListener {
            finish()
        }

        val btnNext = findViewById<MaterialButton>(R.id.btnNext)
        val progressBar = findViewById<ProgressBar>(R.id.lessonProgress)

        btnNext.setOnClickListener {
            if (currentStep < totalSteps - 1) {
                currentStep++
                progressBar.progress = (currentStep + 1) * (100 / totalSteps)
                updateLessonContent()
            } else {
                showCompletionDialog()
            }
        }
    }

    private fun updateUI(topicId: Int) {
        val titles = listOf(
            "",
            "NHỮNG QUY ĐỊNH CHUNG",
            "QUY TẮC GIAO THÔNG ĐƯỜNG BỘ",
            "PHƯƠNG TIỆN THAM GIA GIAO THÔNG",
            "NGƯỜI ĐIỀU KHIỂN PHƯƠNG TIỆN",
            "TUẦN TRA, KIỂM SOÁT",
            "BẢO ĐẢM TRẬT TỰ, AN TOÀN",
            "GIẢI QUYẾT TAI NẠN"
        )
        findViewById<TextView>(R.id.tvLessonTitle).text = titles.getOrElse(topicId) { "Bài học" }
        updateLessonContent()
    }

    private fun updateLessonContent() {
        findViewById<TextView>(R.id.tvSubTitle).text = "Phần ${currentStep + 1}: Nội dung kiến thức"
        findViewById<TextView>(R.id.tvContent).text = "Đây là nội dung chi tiết của trang thứ ${currentStep + 1}. Người học sẽ đọc và nhấn 'Tiếp theo' để chuyển sang trang mới."
        
        val btnNext = findViewById<MaterialButton>(R.id.btnNext)
        if (currentStep == totalSteps - 1) {
            btnNext.text = "Hoàn thành bài học"
        } else {
            btnNext.text = "Tiếp theo"
        }
    }

    private fun showCompletionDialog() {
        AlertDialog.Builder(this)
            .setTitle("Chúc mừng!")
            .setMessage("Bạn đã hoàn thành toàn bộ bài học trong chương này.")
            .setPositiveButton("Quay lại") { _, _ ->
                finish()
            }
            .setCancelable(false)
            .show()
    }
}