package com.teamwork.android.samples.clean.business;

import android.app.Application;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import com.teamwork.android.samples.clean.business.injection.BusinessLayerInitializer;
import com.teamwork.android.samples.clean.business.injection.InternalBusinessComponent;
import com.teamwork.android.samples.clean.business.injection.BusinessComponent;
import com.teamwork.android.samples.data.bridge.DataBridgeInitializer;

/**
 * Contains business layer specific initialization for the main sample {@link Application} concrete class.
 */
@SuppressWarnings("unused")
public abstract class SampleBusinessApplication extends Application {

    private BusinessLayerInitializer businessLayerInitializer;

    @Override
    public void onCreate() {
        super.onCreate();

        // the order of these calls is fundamental for a correct initialization, do NOT modify!
        initializeErrorManagement();
        initializeGlobalDependencyManagement();
        initializeLayers();
    }

    protected void initializeErrorManagement() {
    }

    //region initialize global dependency injection

    protected final void initializeGlobalDependencyManagement() {
        initializeDataComponent();
        BusinessComponent businessComponent = initializeBusinessComponent();
        initializeAppComponent(businessComponent);

        onDependencyManagementInitialized();
    }

    protected abstract void initializeAppComponent(BusinessComponent businessComponent);

    private void initializeDataComponent() {
        DataBridgeInitializer.INSTANCE.initialize(this);
    }

    private @NonNull BusinessComponent initializeBusinessComponent() {
        businessLayerInitializer = new BusinessLayerInitializer();
        businessLayerInitializer.initialize(this);
        return getBusinessComponent();
    }

    /**
     * Initialize any network-related component, such as network API containers, OkHttp and any web sockets.
     */
    protected final void initializeNetworkLayer() {
        DataBridgeInitializer.INSTANCE.initializeNetworkLayer(this);
    }

    /**
     * Initialize global caching components.
     */
    protected final void initializeCacheLayer() {
        DataBridgeInitializer.INSTANCE.initializeCacheLayer(this);
    }

    protected final void initializeBusinessLayer() {
        businessLayerInitializer.initializeBusinessLayer(this);
    }

    @CallSuper
    protected void onDependencyManagementInitialized() {
        initializeLayers();
    }

    protected void initializeLayers() {
        initializeNetworkLayer();
        initializeCacheLayer();
        initializeBusinessLayer();
    }

    //endregion

    protected @NonNull BusinessComponent getBusinessComponent() {
        return InternalBusinessComponent.Companion.getINSTANCE();
    }

}