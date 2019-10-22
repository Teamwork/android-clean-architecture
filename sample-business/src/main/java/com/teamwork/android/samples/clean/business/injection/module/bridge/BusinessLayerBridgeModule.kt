package com.teamwork.android.samples.clean.business.injection.module.bridge

import com.teamwork.android.samples.clean.business.injection.DaggerSampleBusinessComponent
import com.teamwork.android.samples.clean.business.injection.SampleBusinessComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Provider Dagger [Module] where the [SampleBusinessComponent] gets initialized.
 *
 * This module must be be used in the application/presentation layer component to provide the dependencies exposed by
 * the [SampleBusinessComponent].
 */
@Module
object BusinessLayerBridgeModule {

    @Provides
    @Singleton
    @JvmStatic
    fun businessComponent(): SampleBusinessComponent {
        val dataComponent = DaggerSampleBusinessComponent.builder().build()
        SampleBusinessComponent.provider.component = dataComponent
        return dataComponent
    }

}