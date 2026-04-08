package com.example.smarttraffic.ui.lesson

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.home.HomeActivity
import com.example.smarttraffic.ui.profile.ProfileActivity
import com.example.smarttraffic.ui.quiz.QuizPracticeActivity

class LessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        // 1. Nút Back
        findViewById<View>(R.id.btnBack)?.setOnClickListener {
            finish()
        }

        // 2. Click vào các chủ đề bài học
        val topics = listOf(
            R.id.topic1, R.id.topic2, R.id.topic3, R.id.topic4, 
            R.id.topic5, R.id.topic6, R.id.topic7
        )

        topics.forEachIndexed { index, id ->
            findViewById<View>(id)?.setOnClickListener {
                startLesson(index + 1)
            }
        }

        // 3. Bottom Navigation
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

    private fun startLesson(topicId: Int) {
        val intent = Intent(this, LessonDetailActivity::class.java)
        intent.putExtra("topic_id", topicId)
        startActivity(intent)
    }
}