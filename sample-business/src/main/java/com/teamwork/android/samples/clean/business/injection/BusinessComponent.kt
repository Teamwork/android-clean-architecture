package com.teamwork.android.samples.clean.business.injection

import android.content.Context
import com.teamwork.android.samples.clean.business.feature1.detail.Feature1DetailsInteractor
import com.teamwork.android.samples.clean.business.feature1.list.Feature1ListInteractor
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractor
import com.teamwork.android.samples.clean.business.injection.module.internal.InteractorsBindingModule
import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import dagger.BindsInstance
import dagger.Component
import java.util.concurrent.ExecutorService
import javax.inject.Named
import javax.inject.Singleton

interface BusinessComponent {

    companion object {
        const val GLOBAL_COMPUTATION_EXECUTOR = DataAccessComponent.GLOBAL_COMPUTATION_EXECUTOR
    }

    /*
     * Provision methods for public interactors that need to be exposed to the presentation layer.
     * Any other interactor implementation which is not declared here will only be accessible from within this layer.
     */

    fun feature1DetailsInteractor(): Feature1DetailsInteractor

    fun feature1ListInteractor(): Feature1ListInteractor

    fun feature2DetailsInteractor(): Feature2DetailsInteractor


    //region exposed cross-layer dependencies

    @Named(GLOBAL_COMPUTATION_EXECUTOR)
    fun computationExecutor(): ExecutorService

    //endregion

}

@Singleton
@Component(
        modules = [
            InteractorsBindingModule::class
        ],
        dependencies = [
            DataAccessComponent::class
        ]
)
internal interface InternalBusinessComponent : BusinessComponent {

    companion object {
        /**
         * The singleton instance for [InternalBusinessComponent].
         * This is initialised by the `business` layer itself and primarily used to inject internal dependencies.
         * The instance can be replaced with a mock for testing when necessary.
         */
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: InternalBusinessComponent
    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context,
                   dataAccessComponent: DataAccessComponent
        ): InternalBusinessComponent
    }


    //region `data` layer injectable classes

    fun inject(businessLayerInitializer: BusinessLayerInitializer)

    //endregion

}