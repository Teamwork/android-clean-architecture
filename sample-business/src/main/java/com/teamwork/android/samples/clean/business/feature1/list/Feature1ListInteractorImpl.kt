@file:Suppress("unused")

package com.teamwork.android.samples.clean.business.feature1.list

import com.teamwork.android.samples.clean.business.BaseInteractor
import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.entity.feature1.Entity1List
import javax.inject.Inject

class Feature1ListInteractorImpl
@Inject constructor(private val entity1Repo: Entity1Repo)
    : BaseInteractor<Entity1List, Interactor.Callback<Entity1List>>(), Feature1ListInteractor