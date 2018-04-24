package com.teamwork.android.samples.clean.data.injection;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;

import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Singleton;

/**
 * Provider class for classes in 'sample-data' to be able to use dependency injection. Call {@link #getComponent()} to
 * explicitly inject classes in this module.
 * <p>
 * The business layer must take care to set this up at application startup by calling {@link
 * #setComponent(SampleDataComponent)}.
 */
@Singleton
@ThreadSafe
@SuppressWarnings("WeakerAccess")
public class SampleDataComponentProvider {

    private static final SampleDataComponentProvider INSTANCE = new SampleDataComponentProvider();

    @NonNull
    public static SampleDataComponentProvider get() {
        return INSTANCE;
    }

    private volatile SampleDataComponent dataComponent;

    public void setComponent(@NonNull SampleDataComponent component) {
        dataComponent = component;
    }

    @SuppressWarnings("unused")
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    public @NonNull SampleDataComponent getComponent() {
        if (dataComponent == null) {
            throw new IllegalStateException("SampleDataComponent not initialized");
        }
        return dataComponent;
    }

}