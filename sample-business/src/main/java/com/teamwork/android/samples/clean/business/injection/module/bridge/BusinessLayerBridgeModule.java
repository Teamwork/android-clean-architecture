package com.teamwork.android.samples.clean.business.injection.module.bridge;

import com.teamwork.android.samples.clean.business.injection.DaggerSampleBusinessComponent;
import com.teamwork.android.samples.clean.business.injection.SampleBusinessComponent;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Dagger {@link Module} to be used in the 'business' layer component to provide the dependencies exposed by the {@link
 * SampleBusinessComponent}.
 */
@Module
public class BusinessLayerBridgeModule {

    @Provides
    @Singleton
    SampleBusinessComponent businessComponent() {
        SampleBusinessComponent dataComponent = DaggerSampleBusinessComponent.builder().build();
        SampleBusinessComponent.getProvider().setComponent(dataComponent);
        return dataComponent;
    }

}