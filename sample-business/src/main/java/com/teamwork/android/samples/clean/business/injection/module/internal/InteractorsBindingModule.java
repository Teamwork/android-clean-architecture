package com.teamwork.android.samples.clean.business.injection.module.internal;

import com.teamwork.android.samples.clean.business.feature1.detail.Feature1DetailsInteractor;
import com.teamwork.android.samples.clean.business.feature1.detail.Feature1DetailsInteractorImpl;
import com.teamwork.android.samples.clean.business.feature1.list.Feature1ListInteractor;
import com.teamwork.android.samples.clean.business.feature1.list.Feature1ListInteractorImpl;
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractor;
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractorImpl;
import com.teamwork.android.samples.clean.business.injection.module.exported.InteractorsModule;
import dagger.Binds;
import dagger.Module;

import javax.inject.Singleton;

/**
 * This Dagger {@link Module} contains bindings and provider methods for interactors and other related objects which are
 * initialized within the internal business component.
 * <p>
 * To expose the interactors to the app layer (i.e. most interactors will be needed from presenters), declare their
 * interfaces in {@link InteractorsModule}.
 */
@Module
public abstract class InteractorsBindingModule {

    //region interactor binders

    @Binds
    @Singleton
    abstract Feature1DetailsInteractor feature1DetailsInteractor(Feature1DetailsInteractorImpl impl);

    @Binds
    @Singleton
    abstract Feature1ListInteractor feature1ListInteractor(Feature1ListInteractorImpl impl);

    @Binds
    @Singleton
    abstract Feature2DetailsInteractor feature2DetailsInteractor(Feature2DetailsInteractorImpl impl);

    //endregion

}