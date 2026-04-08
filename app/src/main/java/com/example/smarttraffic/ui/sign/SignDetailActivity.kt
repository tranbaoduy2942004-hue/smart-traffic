package com.example.smarttraffic.ui.sign

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.repository.SignRepository

class SignDetailActivity : AppCompatActivity() {

    private lateinit var repository: SignRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_detail)

        repository = SignRepository()

        val signId = intent.getIntExtra("sign_id", -1)
        val sign = repository.getSignById(signId)

        val imgSign = findViewById<ImageView>(R.id.imgSign)
        val tvSignName = findViewById<TextView>(R.id.tvSignName)
        val tvSignMeta = findViewById<TextView>(R.id.tvSignMeta)
        val tvSignDescription = findViewById<TextView>(R.id.tvSignDescription)

        sign?.let {
            imgSign.setImageResource(it.imageResId)
            tvSignName.text = it.name
            tvSignMeta.text = "${convertGroupName(it.group)} - ${it.code}"
            tvSignDescription.text = it.description
        }
    }

    private fun convertGroupName(group: String): String {
        return when (group) {
            "CAM" -> "Nhóm Biển Báo Cấm"
            "NGUY_HIEM" -> "Nhóm Biển Nguy Hiểm"
            "HIEU_LENH" -> "Nhóm Biển Hiệu Lệnh"
            "CHI_DAN" -> "Nhóm Biển Chỉ Dẫn"
            "BIEN_PHU" -> "Nhóm Biển Phụ"
            else -> "Biển báo"
        }
    }
}