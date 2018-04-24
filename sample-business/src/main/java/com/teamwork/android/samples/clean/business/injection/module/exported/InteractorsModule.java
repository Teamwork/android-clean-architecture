package com.teamwork.android.samples.clean.business.injection.module.exported;

import com.teamwork.android.samples.clean.business.feature1.detail.Feature1DetailsInteractor;
import com.teamwork.android.samples.clean.business.feature1.list.Feature1ListInteractor;
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractor;
import com.teamwork.android.samples.clean.business.injection.module.bridge.SampleBusinessBridgeModule;
import dagger.Module;
import dagger.Provides;

/**
 * This Dagger {@link Module} contains bindings and provider methods for interactors and other related objects which are
 * initialized within the internal business component and need to be provided to the application layer (i.e. most
 * interactors will be needed from presenters).
 */
@Module
public class InteractorsModule extends SampleBusinessBridgeModule {

    //region interactor providers

    @Provides
    Feature1DetailsInteractor appLoginFlowInteractor() {
        return getComponent().feature1DetailsInteractor();
    }

    @Provides
    Feature1ListInteractor feature1ListInteractor() {
        return getComponent().feature1ListInteractor();
    }

    @Provides
    Feature2DetailsInteractor feature2DetailsInteractor() {
        return getComponent().feature2DetailsInteractor();
    }

    //endregion

}