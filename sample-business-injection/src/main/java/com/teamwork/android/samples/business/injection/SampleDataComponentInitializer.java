package com.teamwork.android.samples.business.injection;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import com.teamwork.android.samples.clean.data.injection.DaggerSampleDataComponent;
import com.teamwork.android.samples.clean.data.injection.SampleDataComponent;
import com.teamwork.android.samples.clean.data.injection.SampleDataComponentProvider;

import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Singleton;

/**
 * Takes care of initializing the data layer component and dependencies at application startup.
 * <p>
 * Must be initialized once with {@link #initialize(Context)} in the {@link Application#onCreate()}.
 */
@Singleton
@ThreadSafe
@SuppressWarnings("WeakerAccess")
public class SampleDataComponentInitializer {

    private static final SampleDataComponentInitializer INSTANCE = new SampleDataComponentInitializer();

    public static @NonNull SampleDataComponentInitializer get() {
        return INSTANCE;
    }

    private volatile SampleDataComponent projectsDataComponent;

    public void initialize(@NonNull Context appContext) {
        projectsDataComponent = DaggerSampleDataComponent.builder().build();
        SampleDataComponentProvider.get().setComponent(projectsDataComponent);
    }

    public @NonNull SampleDataComponent getDataComponent() {
        if (projectsDataComponent == null) {
            throw new IllegalStateException("ProjectsDataComponent not initialized");
        }
        return projectsDataComponent;
    }

}