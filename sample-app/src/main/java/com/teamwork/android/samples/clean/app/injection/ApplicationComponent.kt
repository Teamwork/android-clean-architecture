package com.teamwork.android.samples.clean.app.injection

import android.content.Context
import com.teamwork.android.samples.clean.app.SampleActivity
import com.teamwork.android.samples.clean.app.feature2.detail.Feature2DetailsActivity
import com.teamwork.android.samples.clean.business.injection.BusinessComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [],
        dependencies = [
            BusinessComponent::class
        ]
)
interface ApplicationComponent {

    companion object {
        /**
         * The singleton instance for [ApplicationComponent].
         * This is initialised by the `presentation` layer itself and primarily used to inject dependencies.
         * The instance can be replaced with a mock for testing when necessary.
         */
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: ApplicationComponent
    }

    @Component.Factory
    interface Factory {
        fun create(
                @BindsInstance applicationContext: Context,
                businessComponent: BusinessComponent
        ): ApplicationComponent

    }

    fun inject(activity: SampleActivity)

    fun inject(activity: Feature2DetailsActivity)

}