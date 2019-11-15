@file:Suppress("unused")

package com.teamwork.android.samples.clean.business.feature1.detail

import android.content.Context
import com.teamwork.android.samples.clean.business.BaseInteractor
import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.entity.feature1.Entity1
import javax.inject.Inject

internal class Feature1DetailsInteractorImpl
@Inject constructor(
        private val context: Context,
        private val entity1Repo: Entity1Repo
) : BaseInteractor<Entity1, Interactor.Callback<Entity1>>(), Feature1DetailsInteractor