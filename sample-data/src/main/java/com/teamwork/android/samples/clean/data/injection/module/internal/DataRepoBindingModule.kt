package com.teamwork.android.samples.clean.data.injection.module.internal

import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.data.access.feature2.Entity2Repo
import com.teamwork.android.samples.clean.data.feature1.Entity1RepoImpl
import com.teamwork.android.samples.clean.data.feature2.Entity2RepoImpl
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

/**
 * Dagger class bindings for data repository components.
 */
@Module
internal object DataRepoBindingModule {

    @Provides
    @Singleton
    fun entity1Repo(repo: Entity1RepoImpl): Entity1Repo = repo

    @Provides
    @Singleton
    fun entity2Repo(repo: Entity2RepoImpl): Entity2Repo = repo

}