package com.teamwork.android.samples.clean.data.injection

import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import com.teamwork.android.samples.clean.data.injection.module.internal.DataRepoBindingModule
import com.teamwork.android.samples.clean.data.injection.module.internal.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Dagger component for dependency injection of classes in the 'sample-data' module (data layer).
 *
 * The [Component] extends from [DataAccessComponent] so that the required "public" dependencies that need
 * to be exposed to the business layer via a provision method (https://google.github.io/dagger/api/2.14/dagger/Component.html)
 * are declared here.
 *
 * TODO: provide an example of an AndroidModule (which provides the app Context and system services) that's used across
 * layers.
 */
@Singleton
@Component(modules = [
    NetworkModule::class,
    // dependency class bindings to expose modules
    DataRepoBindingModule::class
])
interface SampleDataComponent : DataAccessComponent {


    //region data layer internal dependencies

    /* Add here any dependencies which only need to be accessed (manually) from the data layer */

    //endregion


    //region component provider

    class ComponentProvider {

        @Volatile
        lateinit var component: SampleDataComponent

        companion object {
            val COMPONENT_PROVIDER = ComponentProvider()
        }
    }

    companion object {
        val provider: ComponentProvider by lazy { ComponentProvider.COMPONENT_PROVIDER }
    }

    //endregion

}