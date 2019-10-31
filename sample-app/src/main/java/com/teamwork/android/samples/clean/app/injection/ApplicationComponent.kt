package com.teamwork.android.samples.clean.app.injection

import android.content.Context
import com.teamwork.android.samples.clean.app.SampleActivity
import com.teamwork.android.samples.clean.app.feature2.detail.Feature2DetailsActivity
import com.teamwork.android.samples.clean.business.injection.SampleBusinessComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [],
        dependencies = [
            SampleBusinessComponent::class
        ]
)
interface ApplicationComponent {

    fun inject(activity: SampleActivity)

    fun inject(activity: Feature2DetailsActivity)

    @Component.Factory
    interface Factory {
        fun create(
                @BindsInstance applicationContext: Context,
                businessComponent: SampleBusinessComponent
        ): ApplicationComponent
    }

}