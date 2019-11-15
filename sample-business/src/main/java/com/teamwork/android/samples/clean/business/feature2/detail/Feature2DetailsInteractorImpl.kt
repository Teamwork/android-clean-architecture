@file:Suppress("unused")

package com.teamwork.android.samples.clean.business.feature2.detail

import com.teamwork.android.samples.clean.business.BaseInteractor
import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.business.internal.InternalInteractor
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.data.access.feature2.Entity2Repo
import com.teamwork.android.samples.clean.entity.feature2.Entity2
import javax.inject.Inject

internal class Feature2DetailsInteractorImpl
@Inject constructor(
        private val internalInteractor: InternalInteractor,
        private val entity1Repo: Entity1Repo,
        private val entity2Repo: Entity2Repo
        /*
         * private val okHttpClient: OkHttpClient
         * Separation of layers: this won't even compile as OkHttpClient isn't available in 'sample-business'!
         */
) : BaseInteractor<Entity2, Interactor.Callback<Entity2>>(), Feature2DetailsInteractor