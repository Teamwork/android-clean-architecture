package com.teamwork.android.samples.clean.business.injection.module.internal

import com.teamwork.android.samples.clean.business.feature1.detail.Feature1DetailsInteractor
import com.teamwork.android.samples.clean.business.feature1.detail.Feature1DetailsInteractorImpl
import com.teamwork.android.samples.clean.business.feature1.list.Feature1ListInteractor
import com.teamwork.android.samples.clean.business.feature1.list.Feature1ListInteractorImpl
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractor
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractorImpl
import com.teamwork.android.samples.clean.business.injection.SampleBusinessComponent
import com.teamwork.android.samples.clean.business.internal.InternalInteractor
import com.teamwork.android.samples.clean.business.internal.InternalInteractorImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * This Dagger [Module] contains bindings and provider methods for interactors and other related objects which are
 * initialized within the internal business component.
 *
 * To expose the interactors to the app layer (i.e. most interactors will be needed from presenters), declare their
 * interfaces in [SampleBusinessComponent].
 */
@Module
internal interface InteractorsBindingModule {

    //region interactor binders

    @Binds
    fun feature1DetailsInteractor(impl: Feature1DetailsInteractorImpl): Feature1DetailsInteractor

    @Binds
    fun feature1ListInteractor(impl: Feature1ListInteractorImpl): Feature1ListInteractor

    @Binds
    fun feature2DetailsInteractor(impl: Feature2DetailsInteractorImpl): Feature2DetailsInteractor

    @Binds
    @Singleton
    fun internalInteractor(impl: InternalInteractorImpl): InternalInteractor

    //endregion

}