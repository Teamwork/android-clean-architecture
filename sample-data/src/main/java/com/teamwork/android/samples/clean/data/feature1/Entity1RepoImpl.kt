@file:Suppress("UNUSED_PARAMETER")

package com.teamwork.android.samples.clean.data.feature1

import com.squareup.moshi.Moshi
import com.teamwork.android.samples.clean.data.access.DataRequest
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.entity.feature1.Entity1
import com.teamwork.android.samples.clean.entity.feature1.Entity1List
import okhttp3.OkHttpClient
import javax.annotation.concurrent.ThreadSafe
import javax.inject.Inject

@ThreadSafe
class Entity1RepoImpl
@Inject constructor(okHttpClient: OkHttpClient,
                    moshi: Moshi)
    : Entity1Repo {

    override fun getEntity1(id: Long): DataRequest<Entity1> {
        throw UnsupportedOperationException()
    }

    override fun getEntity1List(): DataRequest<Entity1List> {
        throw UnsupportedOperationException()
    }

}