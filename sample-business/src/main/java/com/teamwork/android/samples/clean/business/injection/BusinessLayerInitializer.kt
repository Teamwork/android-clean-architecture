@file:Suppress("UNUSED_PARAMETER")

package com.teamwork.android.samples.clean.business.injection

import android.content.Context
import com.teamwork.android.samples.clean.business.internal.InternalInteractor
import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import javax.inject.Inject

/**
 * Initializer class for the `business` layer.
 *
 * It takes care of triggering the initialization of the [InternalBusinessComponent] from [initialize], and of all the
 * other layer initialization code dependent on the component in [initializeBusinessLayer].
 */
internal class BusinessLayerInitializer {

    @Inject
    lateinit var dataAccessDependency: Entity1Repo
    @Inject
    lateinit var businessInternalDependency: InternalInteractor

    fun initialize(appContext: Context) {
        val dataAccessComponent = DataAccessComponent.INSTANCE
        val businessComponent = DaggerInternalBusinessComponent.factory()
                .create(appContext, dataAccessComponent)
        InternalBusinessComponent.INSTANCE = businessComponent
    }

    fun initializeBusinessLayer(appContext: Context) {
        InternalBusinessComponent.INSTANCE.inject(this)

        dataAccessDependency.initialize()
        businessInternalDependency.initialize()
    }

}