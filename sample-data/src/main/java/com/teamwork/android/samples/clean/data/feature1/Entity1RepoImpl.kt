package com.teamwork.android.samples.clean.data.feature1

import com.teamwork.android.samples.clean.data.access.DataRequest
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.entity.feature1.Entity1
import com.teamwork.android.samples.clean.entity.feature1.Entity1List
import javax.annotation.concurrent.ThreadSafe

@ThreadSafe
class Entity1RepoImpl : Entity1Repo {

    override fun getEntity1(id: Long): DataRequest<Entity1> {
        throw UnsupportedOperationException()
    }

    override fun getEntity1List(): DataRequest<Entity1List> {
        throw UnsupportedOperationException()
    }

}