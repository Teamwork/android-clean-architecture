package com.teamwork.android.samples.clean.data.injection;

import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo;
import com.teamwork.android.samples.clean.data.access.feature2.Entity2Repo;
import com.teamwork.android.samples.clean.data.injection.module.internal.DataRepoBindingModule;
import com.teamwork.android.samples.clean.data.injection.module.internal.NetworkModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component for dependency injection of classes in the 'sample-data' module and declaring which dependencies
 * need to be exposed to the business layer via a provision method (https://google.github.io/dagger/api/2.14/dagger/Component.html).
 * <p>
 * TODO: provide an example of an AndroidModule (which provides the app Context and system services) that's used across
 * layers.
 */
@Singleton
@Component(modules = {
        NetworkModule.class,
        // dependency class bindings to expose modules
        DataRepoBindingModule.class
})
public interface SampleDataComponent {

    /*
     * Provision methods for public repositories that need to be exposed to the business layer.
     * Any other repository implementation which is not declared here will only be accessible from the 'sample-data' module.
     */

    Entity1Repo entity1Repo();

    Entity2Repo entity2Repo();

}