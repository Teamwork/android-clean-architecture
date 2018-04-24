package com.teamwork.android.samples.clean.business;

import android.app.Application;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import com.teamwork.android.samples.business.injection.SampleDataComponentInitializer;
import com.teamwork.android.samples.clean.business.injection.SampleBusinessComponent;
import com.teamwork.android.samples.clean.business.injection.SampleBusinessComponentProvider;

/**
 * Contains business layer specific initialization for the main sample {@link Application} concrete class.
 */
@SuppressWarnings("unused")
public abstract class SampleBusinessApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // the order of these calls is fundamental for a correct initialization, do NOT modify!
        initializeErrorManagement();
        initializeGlobalDependencyManagement();
        initializeComponents();
    }

    protected void initializeErrorManagement() {
    }

    //region initialize global dependency injection

    protected final void initializeGlobalDependencyManagement() {
        initializeAppComponent();
        initializeDataComponent();
        initializeBusinessComponent();

        onDependencyManagementInitialized();
    }

    @CallSuper
    protected void initializeComponents() {
        initializeNetworkLayer();
        initializeCacheLayer();
        initializeBusinessLayer();
    }

    /**
     * Initialize any network-related component, such as network API containers, OkHttp and any web sockets.
     */
    protected void initializeNetworkLayer() {
    }

    /**
     * Initialize global caching components.
     */
    protected void initializeCacheLayer() {
    }

    protected final void initializeBusinessLayer() {
    }

    protected abstract void initializeAppComponent();

    private void initializeDataComponent() {
        SampleDataComponentInitializer.get().initialize(this);
    }

    private void initializeBusinessComponent() {
        SampleBusinessComponentProvider.get().initialize(this);
    }

    protected abstract void onDependencyManagementInitialized();

    //endregion

    protected @NonNull SampleBusinessComponent getBusinessComponent() {
        return SampleBusinessComponentProvider.get().getBusinessComponent();
    }

}