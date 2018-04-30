package com.teamwork.android.samples.clean.data.access;

import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo;
import com.teamwork.android.samples.clean.data.access.feature2.Entity2Repo;

/**
 * Interface that lists all public 'data access' layer components which need to be exposed to dependency injection (i.e.
 * Dagger) and exposed to the business layer.
 * <p>
 * When Dagger is used, by letting the Dagger Component from the 'data layer' extend this interface we declare provision
 * methods (https://google.github.io/dagger/api/2.14/dagger/Component.html) which then can be used in modules to access
 * the necessary dependencies.
 */
public interface DataAccessComponent {

    Entity1Repo entity1Repo();

    Entity2Repo entity2Repo();

}