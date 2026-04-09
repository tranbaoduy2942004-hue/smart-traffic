package com.example.smarttraffic.ui.lesson

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.smarttraffic.R
import com.example.smarttraffic.dto.LawDto
import com.example.smarttraffic.repository.LawApiRepository
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LessonDetailActivity : AppCompatActivity() {

    private val repository = LawApiRepository()
    private var lessonList: List<LawDto> = emptyList()
    private var currentIndex = 0

    private lateinit var tvLessonTitle: TextView
    private lateinit var tvSubTitle: TextView
    private lateinit var tvContent: TextView
    private lateinit var imgLesson: ImageView
    private lateinit var lessonProgress: ProgressBar
    private lateinit var btnNext: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_detail)

        val categoryId = intent.getIntExtra("category_id", -1)
        val categoryName = intent.getStringExtra("category_name") ?: "Nội dung bài học"

        tvLessonTitle = findViewById(R.id.tvLessonTitle)
        tvSubTitle = findViewById(R.id.tvSubTitle)
        tvContent = findViewById(R.id.tvContent)
        imgLesson = findViewById(R.id.imgLesson)
        lessonProgress = findViewById(R.id.lessonProgress)
        btnNext = findViewById(R.id.btnNext)

        tvLessonTitle.text = categoryName

        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }

        btnNext.setOnClickListener {
            handleNext()
        }

        if (categoryId == -1) {
            Toast.makeText(this, "Không tìm thấy chủ đề bài học", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        loadLessons(categoryId)
    }

    private fun loadLessons(categoryId: Int) {
        repository.getLawsByCategory(categoryId).enqueue(object : Callback<List<LawDto>> {
            override fun onResponse(call: Call<List<LawDto>>, response: Response<List<LawDto>>) {
                if (response.isSuccessful) {
                    lessonList = response.body() ?: emptyList()
                    Log.d("LAW_API", "Lessons size = ${lessonList.size}")

                    if (lessonList.isNotEmpty()) {
                        currentIndex = 0
                        displayLesson()
                    } else {
                        Toast.makeText(
                            this@LessonDetailActivity,
                            "Chưa có nội dung cho chủ đề này",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    }
                } else {
                    Log.e("LAW_API", "getLawsByCategory failed: ${response.code()}")
                    Toast.makeText(
                        this@LessonDetailActivity,
                        "Lỗi server: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            }

            override fun onFailure(call: Call<List<LawDto>>, t: Throwable) {
                Log.e("LAW_API", "getLawsByCategory error", t)
                Toast.makeText(
                    this@LessonDetailActivity,
                    "Lỗi tải bài học",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        })
    }

    private fun displayLesson() {
        if (lessonList.isEmpty() || currentIndex !in lessonList.indices) return

        val lesson = lessonList[currentIndex]

        tvSubTitle.text = lesson.title ?: "Không có tiêu đề"

        val contentBuilder = StringBuilder()

        if (!lesson.description.isNullOrBlank()) {
            contentBuilder.append(lesson.description.trim())
        }

        if (!lesson.rules.isNullOrBlank()) {
            if (contentBuilder.isNotEmpty()) contentBuilder.append("\n\n")
            contentBuilder.append("Quy định:\n")
            contentBuilder.append(lesson.rules.trim())
        }

        if (!lesson.warnings.isNullOrBlank()) {
            if (contentBuilder.isNotEmpty()) contentBuilder.append("\n\n")
            contentBuilder.append("Lưu ý:\n")
            contentBuilder.append(lesson.warnings.trim())
        }

        tvContent.text = if (contentBuilder.isNotEmpty()) {
            contentBuilder.toString()
        } else {
            "Chưa có nội dung chi tiết."
        }

        if (!lesson.image_url.isNullOrBlank()) {
            imgLesson.visibility = View.VISIBLE
            Glide.with(this)
                .load(lesson.image_url)
                .placeholder(R.drawable.img_home_banner)
                .error(R.drawable.img_home_banner)
                .into(imgLesson)
        } else {
            imgLesson.visibility = View.GONE
        }

        val progress = ((currentIndex + 1) * 100) / lessonList.size
        lessonProgress.progress = progress

        btnNext.text = if (currentIndex == lessonList.size - 1) {
            "Hoàn thành chương"
        } else {
            "Tiếp theo"
        }
    }

    private fun handleNext() {
        if (currentIndex < lessonList.size - 1) {
            currentIndex++
            displayLesson()
        } else {
            showCompletionDialog()
        }
    }

    private fun showCompletionDialog() {
        AlertDialog.Builder(this)
            .setTitle("Tuyệt vời!")
            .setMessage("Bạn đã hoàn thành toàn bộ nội dung trong chương này.")
            .setPositiveButton("Quay lại") { _, _ -> finish() }
            .setCancelable(false)
            .show()
    }
}