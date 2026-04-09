package com.example.smarttraffic.ui.sign

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttraffic.R
import com.example.smarttraffic.dto.SignDto
import com.example.smarttraffic.repository.SignApiRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignDetailActivity : AppCompatActivity() {

    private lateinit var repository: SignApiRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_detail)

        repository = SignApiRepository()

        val signId = intent.getIntExtra("sign_id", -1)
        if (signId == -1) {
            Toast.makeText(this, "Sign ID không hợp lệ", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val imgSign = findViewById<ImageView>(R.id.imgSign)
        val tvSignName = findViewById<TextView>(R.id.tvSignName)
        val tvSignMeta = findViewById<TextView>(R.id.tvSignMeta)
        val tvSignDescription = findViewById<TextView>(R.id.tvSignDescription)

        repository.getSignById(signId).enqueue(object : Callback<SignDto> {
            override fun onResponse(call: Call<SignDto>, response: Response<SignDto>) {
                if (response.isSuccessful) {
                    val sign = response.body()
                    if (sign != null) {
                        tvSignName.text = sign.title ?: "Không có tên"
                        tvSignMeta.text = "${sign.category_name ?: "Biển báo"} - ${sign.sign_code ?: ""}"
                        tvSignDescription.text = sign.description ?: "Không có mô tả"

                        // Tạm thời để ảnh mặc định vì backend trả image_url text.
                        // Sau này có thể dùng Glide/Picasso để load URL.
                        imgSign.setImageResource(R.drawable.img_quiz)
                    }
                } else {
                    Toast.makeText(this@SignDetailActivity, "Không tải được chi tiết biển", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SignDto>, t: Throwable) {
                Toast.makeText(this@SignDetailActivity, "Lỗi kết nối backend", Toast.LENGTH_SHORT).show()
            }
        })
    }
}