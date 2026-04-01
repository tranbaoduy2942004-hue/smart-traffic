package com.example.smarttraffic.data.fake

import com.example.smarttraffic.R
import com.example.smarttraffic.model.TrafficSign

object FakeSignDataSource {

    fun getAllSigns(): List<TrafficSign> {
        return listOf(
            TrafficSign(
                id = 1,
                code = "P.101",
                name = "Đường cấm",
                description = "Cấm tất cả các loại phương tiện đi vào.",
                category = "Biển cấm",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TrafficSign(
                id = 2,
                code = "W.201",
                name = "Chỗ ngoặt nguy hiểm",
                description = "Báo trước đoạn đường có chỗ ngoặt nguy hiểm.",
                category = "Biển nguy hiểm",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TrafficSign(
                id = 3,
                code = "R.302",
                name = "Hướng phải đi vòng chướng ngại vật",
                description = "Các xe chỉ được đi về bên phải để tránh chướng ngại vật.",
                category = "Biển hiệu lệnh",
                imageResId = R.drawable.ic_launcher_foreground
            )
        )
    }

    fun getSignById(id: Int): TrafficSign? {
        return getAllSigns().find { it.id == id }
    }
}