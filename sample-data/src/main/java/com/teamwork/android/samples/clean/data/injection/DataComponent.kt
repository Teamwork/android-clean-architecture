package com.teamwork.android.samples.clean.data.injection

import android.content.Context
import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import com.teamwork.android.samples.clean.data.injection.module.internal.DataRepoBindingModule
import com.teamwork.android.samples.clean.data.injection.module.internal.NetworkModule
import com.teamwork.android.samples.clean.data.injection.module.internal.ThreadingModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Dagger component for internal dependency injection of classes in the 'sample-data' module (data layer).
 *
 * The [Component] extends from [DataAccessComponent] so that the required "public" dependencies that need
 * to be exposed to the business layer via a [provision method](https://dagger.dev/api/2.25.2/dagger/Component.html)
 * are declared here.
 */
@Singleton
@Component(
        modules = [
            NetworkModule::class,
            ThreadingModule::class,
            // dependency class bindings
            DataRepoBindingModule::class
        ]
)
internal interface DataComponent : DataAccessComponent {

    companion object {
        /**
         * The singleton instance for [DataComponent].
         * This is initialised by the `data` layer itself and primarily used to inject internal dependencies.
         * The instance can be replaced with a mock for testing when necessary.
         */
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: DataComponent
    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): DataComponent
    }

    //region `data` layer internal dependencies

    /* Add here any dependencies which only need to be accessed via provision method from the data layer */

    //endregion


    //region `data` layer injectable classes

    fun inject(dataLayerInitializer: DataLayerInitializer)

    //endregion

}