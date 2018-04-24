package com.teamwork.android.samples.clean.business.injection;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;

import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Singleton;

/**
 * Provider class for classes in 'sample-business' to be able to use dependency injection.
 * <p>
 * <b>Do NOT use this class outside of the sample-business module.</b>
 * <p>
 * The {@link dagger.Component} must be initialized once with {@link #initialize(Context)} from the {@link
 * Application#onCreate()}.
 */
@Singleton
@ThreadSafe
@SuppressWarnings("WeakerAccess")
public class SampleBusinessComponentProvider {

    //region static singleton instance

    private static final SampleBusinessComponentProvider INSTANCE = new SampleBusinessComponentProvider();

    public static @NonNull SampleBusinessComponentProvider get() {
        return INSTANCE;
    }

    //endregion

    private volatile SampleBusinessComponent businessComponent;

    /**
     * Initialize the data and business layer {@link dagger.Component}s. Call this from {@link Application#onCreate()}.
     * <p>
     * Inject here any dependency from the application layer to the business or data layer.
     *
     * @param appContext The application {@link Context}.
     */
    public void initialize(@NonNull Context appContext) {
        businessComponent = DaggerSampleBusinessComponent.builder().build();
    }

    /**
     * Use the {@link SampleBusinessComponent} to inject in classes that require dependencies from the data layer.
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    public @NonNull SampleBusinessComponent getBusinessComponent() {
        return businessComponent;
    }

}