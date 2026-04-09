package com.example.smarttraffic.ui.lesson

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smarttraffic.R
import com.example.smarttraffic.dto.LawCategoryDto
import com.example.smarttraffic.repository.LawApiRepository
import com.example.smarttraffic.ui.adapter.LawCategoryAdapter
import com.example.smarttraffic.ui.home.HomeActivity
import com.example.smarttraffic.ui.profile.ProfileActivity
import com.example.smarttraffic.ui.quiz.QuizPracticeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LessonActivity : AppCompatActivity() {

    private val repository = LawApiRepository()
    private lateinit var adapter: LawCategoryAdapter
    private lateinit var rvLessons: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        findViewById<View>(R.id.btnBack)?.setOnClickListener {
            finish()
        }

        setupRecyclerView()
        loadCategories()
        setupBottomNav()
    }

    private fun setupRecyclerView() {
        rvLessons = findViewById(R.id.rvLessons)

        adapter = LawCategoryAdapter(emptyList()) { category ->
            val intent = Intent(this, LessonDetailActivity::class.java).apply {
                putExtra("category_id", category.id)
                putExtra("category_name", category.name)
            }
            startActivity(intent)
        }

        rvLessons.layoutManager = LinearLayoutManager(this)
        rvLessons.adapter = adapter
        rvLessons.setHasFixedSize(true)
    }

    private fun loadCategories() {
        repository.getCategories().enqueue(object : Callback<List<LawCategoryDto>> {
            override fun onResponse(
                call: Call<List<LawCategoryDto>>,
                response: Response<List<LawCategoryDto>>
            ) {
                if (response.isSuccessful) {
                    val categories = response.body() ?: emptyList()
                    Log.d("LAW_API", "Categories size = ${categories.size}")
                    adapter.updateData(categories)

                    if (categories.isEmpty()) {
                        Toast.makeText(
                            this@LessonActivity,
                            "Chưa có chủ đề luật nào",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Log.e("LAW_API", "getCategories failed: ${response.code()}")
                    Toast.makeText(
                        this@LessonActivity,
                        "Lỗi server: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<LawCategoryDto>>, t: Throwable) {
                Log.e("LAW_API", "getCategories error", t)
                Toast.makeText(
                    this@LessonActivity,
                    "Lỗi kết nối mạng!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun setupBottomNav() {
        findViewById<View>(R.id.navHome)?.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        findViewById<View>(R.id.navQuiz)?.setOnClickListener {
            startActivity(Intent(this, QuizPracticeActivity::class.java))
        }

        findViewById<View>(R.id.navProfile)?.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}