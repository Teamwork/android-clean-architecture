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
 * Dagger component for dependency injection of classes in the 'sample-data' module (data layer).
 *
 * The [Component] extends from [DataAccessComponent] so that the required "public" dependencies that need
 * to be exposed to the business layer via a provision method (https://google.github.io/dagger/api/2.24/dagger/Component.html)
 * are declared here.
 */
@Singleton
@Component(modules = [
    NetworkModule::class,
    ThreadingModule::class,
    // dependency class bindings to expose modules
    DataRepoBindingModule::class
])
interface SampleDataComponent : DataAccessComponent {


    //region data layer internal dependencies

    /* Add here any dependencies which only need to be accessed (manually) from the data layer */

    //endregion


    //region component factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): SampleDataComponent
    }

    object ComponentProvider {

        @Volatile
        lateinit var component: SampleDataComponent
    }

    companion object {
        val provider: ComponentProvider by lazy { ComponentProvider }
    }

    //endregion

}