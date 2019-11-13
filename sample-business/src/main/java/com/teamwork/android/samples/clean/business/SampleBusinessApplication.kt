@file:Suppress("MemberVisibilityCanBePrivate")

package com.teamwork.android.samples.clean.business

import android.app.Application
import android.support.annotation.CallSuper

import com.teamwork.android.samples.clean.business.injection.BusinessComponent
import com.teamwork.android.samples.clean.business.injection.BusinessLayerInitializer
import com.teamwork.android.samples.clean.business.injection.InternalBusinessComponent

/**
 * Contains business layer specific initialization for the main sample [Application] concrete class.
 */
abstract class SampleBusinessApplication : Application() {

    private lateinit var businessLayerInitializer: BusinessLayerInitializer

    //endregion

    protected val businessComponent: BusinessComponent
        get() = InternalBusinessComponent.INSTANCE

    override fun onCreate() {
        super.onCreate()

        // the order of these calls is fundamental for a correct initialization, do NOT modify!
        initializeErrorManagement()
        initializeGlobalDependencyManagement()
        initializeLayers()
    }

    protected fun initializeErrorManagement() {}

    //region initialize global dependency injection

    protected fun initializeGlobalDependencyManagement() {
        initializeDataComponent()
        val businessComponent = initializeBusinessComponent()
        initializeAppComponent(businessComponent)

        onDependencyManagementInitialized()
    }

    protected abstract fun initializeAppComponent(businessComponent: BusinessComponent)

    protected abstract fun initializeDataComponent()

    private fun initializeBusinessComponent(): BusinessComponent {
        businessLayerInitializer = BusinessLayerInitializer()
        businessLayerInitializer.initialize(this)
        return businessComponent
    }

    /**
     * Initialize any network-related component, such as network API containers, OkHttp and any web sockets.
     */
    protected abstract fun initializeNetworkLayer()

    /**
     * Initialize global caching components.
     */
    protected abstract fun initializeCacheLayer()

    protected fun initializeBusinessLayer() {
        businessLayerInitializer.initializeBusinessLayer(this)
    }

    @CallSuper
    protected open fun onDependencyManagementInitialized() {
        initializeLayers()
    }

    @CallSuper
    protected open fun initializeLayers() {
        initializeNetworkLayer()
        initializeCacheLayer()
        initializeBusinessLayer()
    }

}