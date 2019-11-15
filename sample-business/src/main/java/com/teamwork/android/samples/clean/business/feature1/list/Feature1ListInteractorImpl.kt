@file:Suppress("unused")

package com.teamwork.android.samples.clean.business.feature1.list

import com.teamwork.android.samples.clean.business.BaseInteractor
import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.entity.feature1.Entity1List
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import javax.inject.Named

internal class Feature1ListInteractorImpl
@Inject constructor(
        private val entity1Repo: Entity1Repo,

        @Named(DataAccessComponent.GLOBAL_COMPUTATION_EXECUTOR)
        private val computationExecutor: ExecutorService
) : BaseInteractor<Entity1List, Interactor.Callback<Entity1List>>(), Feature1ListInteractor