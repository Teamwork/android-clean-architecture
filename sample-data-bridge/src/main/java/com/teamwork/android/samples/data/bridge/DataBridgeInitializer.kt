package com.teamwork.android.samples.data.bridge

import android.content.Context
import com.teamwork.android.samples.clean.data.injection.DataLayerInitializer
import com.teamwork.android.samples.data.bridge.DataBridgeInitializer.initialize
import com.teamwork.android.samples.data.bridge.DataBridgeInitializer.initializeCacheLayer
import com.teamwork.android.samples.data.bridge.DataBridgeInitializer.initializeNetworkLayer
import javax.annotation.concurrent.ThreadSafe
import javax.inject.Singleton

/**
 * This class is the only purpose of the `data-bridge` module, and it provides a "bridge" for the application layers to
 * bootstrap the initialization of the `data` layer.
 *
 * Since the module is accessible by both `business` and `data` layer, [DataBridgeInitializer] is executed by the business
 * layer during initialization (calling [initialize], and then [initializeNetworkLayer] and [initializeCacheLayer]).
 *
 * @see com.teamwork.android.samples.clean.data.access.DataAccessComponent
 * @see com.teamwork.android.samples.clean.data.injection.DataComponent
 */
@Singleton
@ThreadSafe
object DataBridgeInitializer {

    private val dataInitializer: DataLayerInitializer by lazy { DataLayerInitializer() }

    fun initialize(appContext: Context) {
        dataInitializer.initialize(appContext)
    }

    fun initializeNetworkLayer(appContext: Context) {
        dataInitializer.initializeNetworkLayer(appContext)
    }

    fun initializeCacheLayer(appContext: Context) {
        dataInitializer.initializeCacheLayer(appContext)
    }

}