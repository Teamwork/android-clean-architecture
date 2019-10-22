package com.teamwork.android.samples.clean.app.injection

import android.content.Context
import com.teamwork.android.samples.clean.app.SampleActivity
import com.teamwork.android.samples.clean.app.feature2.detail.Feature2DetailsActivity
import com.teamwork.android.samples.clean.business.injection.module.bridge.BusinessLayerBridgeModule
import com.teamwork.android.samples.clean.business.injection.module.exported.InteractorsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    // business layer interactors
    InteractorsModule::class,
    // business layer module component
    BusinessLayerBridgeModule::class
])
interface ApplicationComponent {

    fun inject(activity: SampleActivity)

    fun inject(activity: Feature2DetailsActivity)

    @Component.Factory
    interface Factory {
        fun create(
                @BindsInstance applicationContext: Context
        ): ApplicationComponent
    }

}