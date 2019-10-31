package com.teamwork.android.samples.data.bridge

import android.content.Context
import com.teamwork.android.samples.clean.data.injection.DataLayerInitializer
import javax.annotation.concurrent.ThreadSafe
import javax.inject.Singleton

/**
 * TODO class header
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