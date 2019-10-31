package com.teamwork.android.samples.clean.app;

import android.app.Application;
import android.support.annotation.NonNull;

import com.teamwork.android.samples.clean.app.injection.ApplicationComponent;
import com.teamwork.android.samples.clean.app.injection.DaggerApplicationComponent;
import com.teamwork.android.samples.clean.business.SampleBusinessApplication;
import com.teamwork.android.samples.clean.business.injection.SampleBusinessComponent;

/**
 * Projects {@link Application} concrete class.
 * <p>
 * Don't use for lengthy unnecessary initializations, as anything executed here on the main thread will delay the
 * application startup and UI.
 */
public class SampleApplication extends SampleBusinessApplication {

    private static SampleApplication instance;

    public static @NonNull SampleApplication getInstance() {
        return instance;
    }

    public static @NonNull ApplicationComponent getAppComponent() {
        return ApplicationComponent.getINSTANCE();
    }

    @Override
    @SuppressWarnings("PMD.CallSuperFirst")
    public void onCreate() {
        instance = this;
        super.onCreate();
    }

    @Override
    protected void initializeAppComponent(SampleBusinessComponent businessComponent) {
        ApplicationComponent.setINSTANCE(buildAppComponent(businessComponent));
    }

    @Override
    protected void onDependencyManagementInitialized() {
        super.onDependencyManagementInitialized();

        // initialize here presentation/view layers
    }

    private @NonNull ApplicationComponent buildAppComponent(SampleBusinessComponent businessComponent) {
        return DaggerApplicationComponent.factory().create(this, businessComponent);
    }

}