package com.teamwork.android.samples.clean.business.injection.module.bridge;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.teamwork.android.samples.clean.business.injection.SampleBusinessComponent;
import com.teamwork.android.samples.clean.business.injection.SampleBusinessComponentProvider;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Base abstract class for Dagger modules in the application layer which require access to the {@link
 * SampleBusinessComponent} dependencies.
 */
@ThreadSafe
@RestrictTo(RestrictTo.Scope.LIBRARY)
public abstract class SampleBusinessBridgeModule {

    private volatile SampleBusinessComponent component;

    protected @NonNull SampleBusinessComponent getComponent() {
        if (component == null) {
            component = getStaticDataComponent();
        }
        return component;
    }

    @SuppressWarnings("WeakerAccess")
    protected static @NonNull SampleBusinessComponent getStaticDataComponent() {
        return SampleBusinessComponentProvider.get().getBusinessComponent();
    }

}