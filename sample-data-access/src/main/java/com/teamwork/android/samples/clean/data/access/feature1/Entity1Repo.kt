package com.teamwork.android.samples.clean.data.access.feature1

import androidx.annotation.AnyThread
import com.teamwork.android.samples.clean.data.access.DataRepo
import com.teamwork.android.samples.clean.data.access.DataRequest
import com.teamwork.android.samples.clean.entity.feature1.Entity1
import com.teamwork.android.samples.clean.entity.feature1.Entity1List

@AnyThread
interface Entity1Repo : DataRepo {

    fun initialize()

    fun getEntity1(id: Long): DataRequest<Entity1>

    fun getEntity1List(): DataRequest<Entity1List>

}