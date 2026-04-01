package com.example.smarttraffic.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.ui.assistant.AssistantActivity
import com.example.smarttraffic.ui.favorite.FavoriteActivity
import com.example.smarttraffic.ui.lesson.LessonActivity
import com.example.smarttraffic.ui.map.MapActivity
import com.example.smarttraffic.ui.profile.ProfileActivity
import com.example.smarttraffic.ui.quiz.QuizPracticeActivity
import com.example.smarttraffic.ui.search.SearchActivity
import com.example.smarttraffic.ui.sign.SignListActivity
import com.example.smarttraffic.ui.simulation.SimulationListActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 1. Nút Học biển báo - KHỚP ID cardSign
        findViewById<View>(R.id.cardSign)?.setOnClickListener {
            val intent = Intent(this, SignListActivity::class.java)
            startActivity(intent)
        }

        // 2. Các nút chức năng khác
        findViewById<View>(R.id.cardQuiz)?.setOnClickListener {
            startActivity(Intent(this, QuizPracticeActivity::class.java))
        }

        findViewById<View>(R.id.cardSimulation)?.setOnClickListener {
            startActivity(Intent(this, SimulationListActivity::class.java))
        }

        findViewById<View>(R.id.cardLesson)?.setOnClickListener {
            startActivity(Intent(this, LessonActivity::class.java))
        }

        findViewById<View>(R.id.cardExam)?.setOnClickListener {
            startActivity(Intent(this, QuizPracticeActivity::class.java))
        }

        findViewById<View>(R.id.cardMap)?.setOnClickListener {
            startActivity(Intent(this, MapActivity::class.java))
        }

        // --- HEADER & SEARCH ---
        findViewById<View>(R.id.btnProfile)?.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        findViewById<View>(R.id.btnSearch)?.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        findViewById<View>(R.id.btnAssistant)?.setOnClickListener {
            startActivity(Intent(this, AssistantActivity::class.java))
        }

        // --- BOTTOM NAVIGATION ---
        findViewById<View>(R.id.navStudy)?.setOnClickListener {
            startActivity(Intent(this, LessonActivity::class.java))
        }

        findViewById<View>(R.id.navQuiz)?.setOnClickListener {
            startActivity(Intent(this, QuizPracticeActivity::class.java))
        }

        findViewById<View>(R.id.navMap)?.setOnClickListener {
            startActivity(Intent(this, MapActivity::class.java))
        }

        findViewById<View>(R.id.navProfile)?.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}