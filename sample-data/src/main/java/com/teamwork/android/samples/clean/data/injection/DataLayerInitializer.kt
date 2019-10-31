@file:Suppress("unused", "UNUSED_PARAMETER")

package com.teamwork.android.samples.clean.data.injection

import android.content.Context
import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import javax.annotation.concurrent.ThreadSafe
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Initializer class for the `data` layer.
 *
 * It takes care of triggering the initialization of the [SampleDataComponent] from [initialize], and of all the
 * other layer initialization code dependent on the component in [initializeNetworkLayer] and [initializeCacheLayer].
 */
@Singleton
@ThreadSafe
class DataLayerInitializer {

    @Inject
    lateinit var entity1Repo: Entity1Repo

    fun initialize(appContext: Context) {
        initializeDataComponent(appContext)

        SampleDataComponent.INSTANCE.inject(this)
    }

    private fun initializeDataComponent(appContext: Context): SampleDataComponent {
        val dataComponent = DaggerSampleDataComponent.factory().create(appContext)
        SampleDataComponent.INSTANCE = dataComponent
        DataAccessComponent.INSTANCE = dataComponent
        return dataComponent
    }

    fun initializeNetworkLayer(appContext: Context) {}

    fun initializeCacheLayer(appContext: Context) {}

}