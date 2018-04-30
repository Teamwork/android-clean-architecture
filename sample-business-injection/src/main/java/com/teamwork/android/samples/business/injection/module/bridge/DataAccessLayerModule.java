package com.teamwork.android.samples.business.injection.module.bridge;

import com.teamwork.android.samples.clean.data.access.DataAccessComponent;
import com.teamwork.android.samples.clean.data.injection.DaggerSampleDataComponent;
import com.teamwork.android.samples.clean.data.injection.SampleDataComponent;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Dagger {@link Module} to be declared in the 'business' layer component to provide the dependencies exposed by the
 * {@link DataAccessComponent}.
 */
@Module
public class DataAccessLayerModule {

    @Provides
    @Singleton
    DataAccessComponent dataAccessComponent() {
        SampleDataComponent dataComponent = DaggerSampleDataComponent.builder().build();
        SampleDataComponent.getProvider().setComponent(dataComponent);
        return dataComponent;
    }

}