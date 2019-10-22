package com.teamwork.android.samples.business.injection.module.exported

import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.data.access.feature2.Entity2Repo
import dagger.Module
import dagger.Provides

/**
 * Bridge Dagger module that exposes data repository dependencies from the data layer to the 'sample-business' module.
 */
@Module
object DataRepoModule {

    @Provides
    @JvmStatic
    fun entity1Repo(component: DataAccessComponent): Entity1Repo = component.entity1Repo()

    @Provides
    @JvmStatic
    fun projectsRepo(component: DataAccessComponent): Entity2Repo = component.entity2Repo()

}