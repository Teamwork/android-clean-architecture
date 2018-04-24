@file:Suppress("UNUSED_PARAMETER")

package com.teamwork.android.samples.clean.data.feature2

import com.squareup.moshi.Moshi
import com.teamwork.android.samples.clean.data.access.DataRequest
import com.teamwork.android.samples.clean.data.access.feature2.Entity2Repo
import com.teamwork.android.samples.clean.entity.feature2.Entity2
import okhttp3.OkHttpClient
import javax.annotation.concurrent.ThreadSafe
import javax.inject.Inject

@ThreadSafe
class Entity2RepoImpl
@Inject constructor(okHttpClient: OkHttpClient,
                    moshi: Moshi)
    : Entity2Repo {

    override fun getEntity2(id: Long): DataRequest<Entity2> {
        throw UnsupportedOperationException()
    }

}