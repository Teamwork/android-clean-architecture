package com.teamwork.android.samples.clean.business.injection.module.internal

import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import dagger.Module
import dagger.Provides
import java.util.concurrent.ExecutorService
import javax.inject.Named
import javax.inject.Singleton

/**
 * Business layer threading module.
 * In order to reuse the same dependencies ([ExecutorService]s in this case) across the whole application, we provide
 * the named singleton instances by delegating to the [DataAccessComponent].
 * This way we are guaranteed that a new instance of the dependencies won't be created.
 */
@Module
internal object BusinessThreadingModule {

    @Provides
    @Singleton
    @JvmStatic
    @Named(DataAccessComponent.GLOBAL_IO_EXECUTOR)
    fun ioExecutorService(component: DataAccessComponent): ExecutorService = component.ioExecutor()

    @Provides
    @Singleton
    @JvmStatic
    @Named(DataAccessComponent.GLOBAL_COMPUTATION_EXECUTOR)
    fun computationExecutorService(component: DataAccessComponent): ExecutorService = component.computationExecutor()

}