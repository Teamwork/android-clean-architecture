package com.teamwork.android.samples.business.injection.module.bridge;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.teamwork.android.samples.business.injection.SampleDataComponentInitializer;
import com.teamwork.android.samples.clean.data.injection.SampleDataComponent;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Base abstract class for Dagger modules that require access to the {@link SampleDataComponent} dependencies.
 */
@ThreadSafe
@RestrictTo(RestrictTo.Scope.LIBRARY)
public abstract class SampleDataBridgeModule {

    private volatile SampleDataComponent component;

    protected @NonNull SampleDataComponent getComponent() {
        if (component == null) {
            component = getStaticDataComponent();
        }
        return component;
    }

    @SuppressWarnings("WeakerAccess")
    protected static @NonNull SampleDataComponent getStaticDataComponent() {
        return SampleDataComponentInitializer.get().getDataComponent();
    }

}