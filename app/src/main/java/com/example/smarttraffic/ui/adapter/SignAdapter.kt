package com.example.smarttraffic.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smarttraffic.R
import com.example.smarttraffic.dto.SignDto

class SignAdapter(
    private var signs: List<SignDto>,
    private val onItemClick: (SignDto) -> Unit
) : RecyclerView.Adapter<SignAdapter.SignViewHolder>() {

    class SignViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgSign: ImageView = view.findViewById(R.id.imgSign1)
        val tvName: TextView = view.findViewById(R.id.tvName1)
        val tvCode: TextView = view.findViewById(R.id.tvCode1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SignViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sign_grid, parent, false)
        return SignViewHolder(view)
    }

    override fun onBindViewHolder(holder: SignViewHolder, position: Int) {
        val sign = signs[position]
        holder.tvName.text = sign.title
        holder.tvCode.text = sign.sign_code
        // Ở đây bạn có thể dùng thư viện Glide hoặc Picasso để tải ảnh từ sign.image_url
        // holder.imgSign.setImageResource(...)
        
        holder.itemView.setOnClickListener { onItemClick(sign) }
    }

    override fun getItemCount() = signs.size

    fun updateData(newSigns: List<SignDto>) {
        this.signs = newSigns
        notifyDataSetChanged()
    }
}