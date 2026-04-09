package com.example.smarttraffic.ui.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.dto.LawCategoryDto
import com.example.smarttraffic.repository.LawApiRepository
import com.example.smarttraffic.ui.home.HomeActivity
import com.example.smarttraffic.ui.profile.ProfileActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuizPracticeActivity : AppCompatActivity() {

    private val lawRepository = LawApiRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_practice)

        val layoutTopic = findViewById<View>(R.id.layoutTopicList)
        val layoutExam = findViewById<View>(R.id.layoutExamList)
        val tvTabTopic = findViewById<TextView>(R.id.tvTabTopic)
        val tvTabExam = findViewById<TextView>(R.id.tvTabExam)
        val indicatorTopic = findViewById<View>(R.id.indicatorTopic)
        val indicatorExam = findViewById<View>(R.id.indicatorExam)

        // 1. Mặc định tải danh sách chủ đề từ Backend
        loadTopicsFromApi()

        // 2. Xử lý chuyển Tab
        findViewById<View>(R.id.tabTopic).setOnClickListener {
            layoutTopic.visibility = View.VISIBLE
            layoutExam.visibility = View.GONE
            tvTabTopic.setTextColor(getColor(R.color.black)) 
            tvTabExam.setTextColor(getColor(android.R.color.darker_gray))
            indicatorTopic.visibility = View.VISIBLE
            indicatorExam.visibility = View.INVISIBLE
        }

        findViewById<View>(R.id.tabExam).setOnClickListener {
            layoutTopic.visibility = View.GONE
            layoutExam.visibility = View.VISIBLE
            tvTabExam.setTextColor(getColor(R.color.black))
            tvTabTopic.setTextColor(getColor(android.R.color.darker_gray))
            indicatorTopic.visibility = View.INVISIBLE
            indicatorExam.visibility = View.VISIBLE
        }

        // 3. Logic thi thử (Exam Mode)
        findViewById<View>(R.id.cardExamSet1).setOnClickListener {
            startQuiz("exam", "b2", null)
        }

        // 4. Điều hướng
        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }
        findViewById<View>(R.id.navHome).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        findViewById<View>(R.id.navProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    private fun loadTopicsFromApi() {
        // Tải danh mục bài học/quiz từ Backend
        lawRepository.getCategories().enqueue(object : Callback<List<LawCategoryDto>> {
            override fun onResponse(call: Call<List<LawCategoryDto>>, response: Response<List<LawCategoryDto>>) {
                if (response.isSuccessful) {
                    val categories = response.body()
                    // Tại đây bạn có thể dùng RecyclerView để hiển thị categories.size chủ đề
                    // Demo: Gán sự kiện cho card đầu tiên nếu có dữ liệu
                    if (!categories.isNullOrEmpty()) {
                        findViewById<View>(R.id.cardTopicLaw).setOnClickListener {
                            startQuiz("topic", "b2", categories[0].id)
                        }
                    }
                }
            }
            override fun onFailure(call: Call<List<LawCategoryDto>>, t: Throwable) {
                Toast.makeText(this@QuizPracticeActivity, "Không thể tải danh sách chủ đề", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun startQuiz(mode: String, license: String, categoryId: Int?) {
        val intent = Intent(this, SignQuizActivity::class.java)
        intent.putExtra("mode", mode)
        intent.putExtra("license", license)
        categoryId?.let { intent.putExtra("category_id", it) }
        startActivity(intent)
    }
}