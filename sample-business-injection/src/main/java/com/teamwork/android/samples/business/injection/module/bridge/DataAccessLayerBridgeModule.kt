package com.teamwork.android.samples.business.injection.module.bridge

import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import com.teamwork.android.samples.clean.data.injection.DaggerSampleDataComponent
import com.teamwork.android.samples.clean.data.injection.SampleDataComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Provider Dagger [Module] where the [SampleDataComponent] gets initialized.
 *
 * This module should be declared in the business layer component to provide the dependencies exposed by the [ ].
 */
@Module
object DataAccessLayerBridgeModule {

    @Provides
    @Singleton
    @JvmStatic
    fun dataAccessComponent(): DataAccessComponent {
        val dataComponent = DaggerSampleDataComponent.builder().build()
        SampleDataComponent.provider.component = dataComponent
        return dataComponent
    }

}