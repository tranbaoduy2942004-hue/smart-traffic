package com.example.smarttraffic.ui.sign

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smarttraffic.R
import com.example.smarttraffic.dto.SignDto
import com.example.smarttraffic.repository.SignApiRepository
import com.example.smarttraffic.ui.adapter.SignAdapter
import com.example.smarttraffic.ui.home.HomeActivity
import com.example.smarttraffic.ui.profile.ProfileActivity
import com.example.smarttraffic.ui.quiz.QuizPracticeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignCategoryActivity : AppCompatActivity() {

    private val repository = SignApiRepository()
    private lateinit var signAdapter: SignAdapter
    private lateinit var rvSigns: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_category)

        val categoryId = intent.getIntExtra("category_id", 1)
        val title = intent.getStringExtra("category_title") ?: "Danh sách biển báo"
        findViewById<TextView>(R.id.tvCategoryTitle).text = title

        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }

        setupRecyclerView()
        loadSigns(categoryId)
        setupBottomNav()
    }

    private fun setupRecyclerView() {
        rvSigns = findViewById(R.id.rvSigns)
        signAdapter = SignAdapter(emptyList()) { sign ->
            openDetail(sign.id)
        }
        rvSigns.layoutManager = GridLayoutManager(this, 2)
        rvSigns.adapter = signAdapter
    }

    private fun loadSigns(categoryId: Int) {
        repository.getSignsByCategory(categoryId).enqueue(object : Callback<List<SignDto>> {
            override fun onResponse(call: Call<List<SignDto>>, response: Response<List<SignDto>>) {
                if (response.isSuccessful) {
                    val signs = response.body() ?: emptyList()
                    signAdapter.updateData(signs)
                    if (signs.isEmpty()) {
                        Toast.makeText(this@SignCategoryActivity, "Không có dữ liệu biển báo cho nhóm này", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.e("API_ERROR", "Error code: ${response.code()}")
                    Toast.makeText(this@SignCategoryActivity, "Lỗi server: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<SignDto>>, t: Throwable) {
                Log.e("API_FAILURE", t.message ?: "Unknown error")
                Toast.makeText(this@SignCategoryActivity, "Lỗi kết nối đến Backend", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun openDetail(signId: Int) {
        val intent = Intent(this, SignDetailActivity::class.java)
        intent.putExtra("sign_id", signId)
        startActivity(intent)
    }

    private fun setupBottomNav() {
        findViewById<View>(R.id.navHome).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
        findViewById<View>(R.id.navStudy).setOnClickListener {
            val intent = Intent(this, SignListActivity::class.java)
            startActivity(intent)
            finish()
        }
        findViewById<View>(R.id.navQuiz).setOnClickListener {
            startActivity(Intent(this, QuizPracticeActivity::class.java))
        }
        findViewById<View>(R.id.navProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}