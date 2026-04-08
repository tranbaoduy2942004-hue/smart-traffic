package com.example.smarttraffic.repository

import com.example.smarttraffic.data.fake.FakeSignDataSource
import com.example.smarttraffic.model.TrafficSign

class SignRepository {

    fun getSignsByGroup(group: String): List<TrafficSign> {
        return FakeSignDataSource.getSignsByGroup(group)
    }

    fun getSignById(id: Int): TrafficSign? {
        return FakeSignDataSource.getSignById(id)
    }
}