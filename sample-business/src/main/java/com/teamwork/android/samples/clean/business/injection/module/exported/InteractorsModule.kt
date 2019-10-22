package com.teamwork.android.samples.clean.business.injection.module.exported

import com.teamwork.android.samples.clean.business.feature1.detail.Feature1DetailsInteractor
import com.teamwork.android.samples.clean.business.feature1.list.Feature1ListInteractor
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractor
import com.teamwork.android.samples.clean.business.injection.SampleBusinessComponent
import dagger.Module
import dagger.Provides

/**
 * This Dagger [Module] contains bindings and provider methods for interactors and other related objects which are
 * initialized within the business component and need to be provided to the application layer (i.e. most interactors
 * will be needed from presenters).
 */
@Module
object InteractorsModule {

    //region interactor providers

    @Provides
    @JvmStatic
    fun appLoginFlowInteractor(component: SampleBusinessComponent): Feature1DetailsInteractor =
            component.feature1DetailsInteractor()

    @Provides
    @JvmStatic
    fun feature1ListInteractor(component: SampleBusinessComponent): Feature1ListInteractor =
            component.feature1ListInteractor()

    @Provides
    @JvmStatic
    fun feature2DetailsInteractor(component: SampleBusinessComponent): Feature2DetailsInteractor =
            component.feature2DetailsInteractor()

    //endregion

}