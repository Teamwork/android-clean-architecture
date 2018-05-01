package com.teamwork.android.samples.business.injection.module.bridge;

import com.teamwork.android.samples.clean.data.access.DataAccessComponent;
import com.teamwork.android.samples.clean.data.injection.DaggerSampleDataComponent;
import com.teamwork.android.samples.clean.data.injection.SampleDataComponent;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Provider Dagger {@link Module} where the {@link SampleDataComponent} gets initialized.
 * <p>
 * This module should be declared in the business layer component to provide the dependencies exposed by the {@link
 * DataAccessComponent}.
 */
@Module
public class DataAccessLayerBridgeModule {

    @Provides
    @Singleton
    DataAccessComponent dataAccessComponent() {
        SampleDataComponent dataComponent = DaggerSampleDataComponent.builder().build();
        SampleDataComponent.getProvider().setComponent(dataComponent);
        return dataComponent;
    }

}