package com.example.smarttraffic.data.fake

import com.example.smarttraffic.R
import com.example.smarttraffic.model.TrafficSign

object FakeSignDataSource {

    const val GROUP_CAM = "CAM"
    const val GROUP_NGUY_HIEM = "NGUY_HIEM"
    const val GROUP_HIEU_LENH = "HIEU_LENH"
    const val GROUP_CHI_DAN = "CHI_DAN"
    const val GROUP_BIEN_PHU = "BIEN_PHU"

    fun getAllSigns(): List<TrafficSign> {
        return listOf(
            TrafficSign(
                id = 1,
                code = "P.101",
                name = "Đường cấm",
                description = "Cấm tất cả các loại phương tiện đi vào.",
                group = GROUP_CAM,
                imageResId = R.drawable.img_quiz
            ),
            TrafficSign(
                id = 2,
                code = "P.102",
                name = "Cấm đi ngược chiều",
                description = "Cấm các phương tiện đi vào theo chiều đặt biển.",
                group = GROUP_CAM,
                imageResId = R.drawable.img_quiz
            ),
            TrafficSign(
                id = 3,
                code = "W.208",
                name = "Giao nhau với đường ưu tiên",
                description = "Báo trước nơi giao nhau với đường ưu tiên.",
                group = GROUP_NGUY_HIEM,
                imageResId = R.drawable.bien_w208
            ),
            TrafficSign(
                id = 4,
                code = "W.201",
                name = "Chỗ ngoặt nguy hiểm",
                description = "Báo trước chỗ ngoặt nguy hiểm.",
                group = GROUP_NGUY_HIEM,
                imageResId = R.drawable.img_quiz
            ),
            TrafficSign(
                id = 5,
                code = "R.301",
                name = "Hướng đi phải theo",
                description = "Các xe chỉ được đi theo hướng mũi tên chỉ.",
                group = GROUP_HIEU_LENH,
                imageResId = R.drawable.img_quiz
            ),
            TrafficSign(
                id = 6,
                code = "R.302",
                name = "Hướng phải đi vòng chướng ngại vật",
                description = "Chỉ dẫn hướng đi tránh chướng ngại vật.",
                group = GROUP_HIEU_LENH,
                imageResId = R.drawable.img_quiz
            ),
            TrafficSign(
                id = 7,
                code = "I.401",
                name = "Bắt đầu khu đông dân cư",
                description = "Chỉ dẫn bắt đầu khu đông dân cư.",
                group = GROUP_CHI_DAN,
                imageResId = R.drawable.img_quiz
            ),
            TrafficSign(
                id = 8,
                code = "I.408",
                name = "Nơi đỗ xe",
                description = "Chỉ dẫn nơi được phép đỗ xe.",
                group = GROUP_CHI_DAN,
                imageResId = R.drawable.img_quiz
            ),
            TrafficSign(
                id = 9,
                code = "S.501",
                name = "Phạm vi tác dụng của biển",
                description = "Biển phụ chỉ phạm vi tác dụng của biển chính.",
                group = GROUP_BIEN_PHU,
                imageResId = R.drawable.img_quiz
            ),
            TrafficSign(
                id = 10,
                code = "S.503",
                name = "Hướng tác dụng của biển",
                description = "Biển phụ chỉ hướng tác dụng của biển chính.",
                group = GROUP_BIEN_PHU,
                imageResId = R.drawable.img_quiz
            )
        )
    }

    fun getSignsByGroup(group: String): List<TrafficSign> {
        return getAllSigns().filter { it.group == group }
    }

    fun getSignById(id: Int): TrafficSign? {
        return getAllSigns().find { it.id == id }
    }
}