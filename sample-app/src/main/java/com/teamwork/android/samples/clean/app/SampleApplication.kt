@file:Suppress("RedundantOverride")

package com.teamwork.android.samples.clean.app

import android.app.Application

import com.teamwork.android.samples.clean.app.injection.ApplicationComponent
import com.teamwork.android.samples.clean.app.injection.DaggerApplicationComponent
import com.teamwork.android.samples.clean.business.SampleBusinessApplication
import com.teamwork.android.samples.clean.business.injection.BusinessComponent
import com.teamwork.android.samples.data.bridge.DataBridgeInitializer

/**
 * Projects [Application] concrete class.
 *
 * Don't use for lengthy unnecessary initializations, as anything executed here on the main thread will delay the
 * application startup and UI.
 */
class SampleApplication : SampleBusinessApplication() {

    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    override fun initializeAppComponent(businessComponent: BusinessComponent) {
        ApplicationComponent.INSTANCE = buildAppComponent(businessComponent)
    }

    override fun initializeDataComponent() {
        DataBridgeInitializer.initialize(this)
    }

    override fun initializeNetworkLayer() {
        DataBridgeInitializer.initializeNetworkLayer(this)
    }

    override fun initializeCacheLayer() {
        DataBridgeInitializer.initializeCacheLayer(this)
    }

    override fun onDependencyManagementInitialized() {
        super.onDependencyManagementInitialized()

        // initialize here presentation/view layers if necessary
    }

    private fun buildAppComponent(businessComponent: BusinessComponent): ApplicationComponent {
        return DaggerApplicationComponent.factory().create(this, businessComponent)
    }

    companion object {

        lateinit var instance: SampleApplication
            private set

        val appComponent: ApplicationComponent
            get() = ApplicationComponent.INSTANCE
    }

}