package com.teamwork.android.samples.clean.business.injection

import android.content.Context
import android.support.annotation.RestrictTo
import com.teamwork.android.samples.business.injection.module.bridge.DataAccessLayerBridgeModule
import com.teamwork.android.samples.business.injection.module.exported.DataRepoModule
import com.teamwork.android.samples.clean.business.feature1.detail.Feature1DetailsInteractor
import com.teamwork.android.samples.clean.business.feature1.list.Feature1ListInteractor
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractor
import com.teamwork.android.samples.clean.business.injection.module.internal.BusinessThreadingModule
import com.teamwork.android.samples.clean.business.injection.module.internal.InteractorsBindingModule
import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import dagger.BindsInstance
import dagger.Component
import java.util.concurrent.ExecutorService
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [
    BusinessThreadingModule::class,
    InteractorsBindingModule::class,
    DataRepoModule::class,
    // data access layer dependencies
    DataAccessLayerBridgeModule::class
])
interface SampleBusinessComponent {

    /*
     * Provision methods for public interactors that need to be exposed to the presentation layer.
     * Any other interactor implementation which is not declared here will only be accessible from the other modules.
     */

    fun feature1DetailsInteractor(): Feature1DetailsInteractor

    fun feature1ListInteractor(): Feature1ListInteractor

    fun feature2DetailsInteractor(): Feature2DetailsInteractor


    //region exposed cross-layer dependencies

    @Named(GLOBAL_COMPUTATION_EXECUTOR)
    fun computationExecutor(): ExecutorService

    //endregion


    //region component factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): SampleBusinessComponent
    }

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    object ComponentProvider {

        @Volatile
        lateinit var component: SampleBusinessComponent
    }

    companion object {

        const val GLOBAL_COMPUTATION_EXECUTOR = DataAccessComponent.GLOBAL_COMPUTATION_EXECUTOR

        val provider: ComponentProvider by lazy { ComponentProvider }
    }

    //endregion

}