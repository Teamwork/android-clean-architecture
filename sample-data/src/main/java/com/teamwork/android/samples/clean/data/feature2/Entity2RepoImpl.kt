package com.teamwork.android.samples.clean.data.feature2

import com.teamwork.android.samples.clean.data.access.DataRequest
import com.teamwork.android.samples.clean.data.access.feature2.Entity2Repo
import com.teamwork.android.samples.clean.entity.feature2.Entity2
import javax.annotation.concurrent.ThreadSafe

@ThreadSafe
class Entity2RepoImpl : Entity2Repo {

    override fun getEntity2(id: Long): DataRequest<Entity2> {
        throw UnsupportedOperationException()
    }

}