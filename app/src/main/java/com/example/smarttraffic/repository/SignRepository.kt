package com.example.smarttraffic.repository

import com.example.smarttraffic.data.fake.FakeSignDataSource
import com.example.smarttraffic.model.TrafficSign

class SignRepository {

    fun getAllSigns(): List<TrafficSign> {
        return FakeSignDataSource.getAllSigns()
    }

    fun getSignById(id: Int): TrafficSign? {
        return FakeSignDataSource.getSignById(id)
    }
}