package com.teamwork.android.samples.clean.data.access.feature2

import androidx.annotation.AnyThread
import com.teamwork.android.samples.clean.data.access.DataRepo
import com.teamwork.android.samples.clean.data.access.DataRequest
import com.teamwork.android.samples.clean.entity.feature2.Entity2

@AnyThread
interface Entity2Repo : DataRepo {

    fun getEntity2(id: Long): DataRequest<Entity2>

}