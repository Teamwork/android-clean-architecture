package com.teamwork.android.samples.business.injection.module.exported;

import com.teamwork.android.samples.business.injection.module.bridge.SampleDataBridgeModule;
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo;
import com.teamwork.android.samples.clean.data.access.feature2.Entity2Repo;
import dagger.Module;
import dagger.Provides;

/**
 * Bridge Dagger module that exposes data repository dependencies from the data layer to the 'sample-business' module.
 */
@Module
public class DataRepoModule extends SampleDataBridgeModule {

    @Provides
    Entity1Repo entity1Repo() {
        return getComponent().entity1Repo();
    }

    @Provides
    Entity2Repo projectsRepo() {
        return getComponent().entity2Repo();
    }

}