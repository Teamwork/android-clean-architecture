package com.teamwork.android.samples.clean.data.injection.module.internal

import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import dagger.Module
import dagger.Provides
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Named
import javax.inject.Singleton

/**
 * [Module] that provide singleton [ExecutorService] for thread pools that will be reused across the application.
 *
 * This could also include custom RxJava `Scheduler`s or any other global, cross-layer threading dependency.
 */
@Module
internal object ThreadingModule {

    @Provides
    @Singleton
    @JvmStatic
    @Named(DataAccessComponent.GLOBAL_COMPUTATION_EXECUTOR)
    fun computationExecutorService(): ExecutorService =
            // note: this thread pool sizing isn't reliable, it's just provided as an example
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    @Provides
    @Singleton
    @JvmStatic
    @Named(DataAccessComponent.GLOBAL_IO_EXECUTOR)
    fun ioExecutorService(): ExecutorService = Executors.newCachedThreadPool()

}