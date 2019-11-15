@file:Suppress("unused")

package com.teamwork.android.samples.clean.business.internal

import com.teamwork.android.samples.clean.business.BaseInteractor
import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.data.access.feature2.Entity2Repo
import com.teamwork.android.samples.clean.entity.feature2.Entity2
import javax.inject.Inject

internal class InternalInteractorImpl
@Inject constructor(
        private val entity1Repo: Entity1Repo,
        private val entity2Repo: Entity2Repo
) : BaseInteractor<Entity2, Interactor.Callback<Entity2>>(), InternalInteractor {

    override fun initialize() {} // does initialization stuff!

}