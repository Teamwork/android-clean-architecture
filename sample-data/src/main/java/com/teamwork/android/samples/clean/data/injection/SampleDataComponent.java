package com.teamwork.android.samples.clean.data.injection;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.teamwork.android.samples.clean.data.access.DataAccessComponent;
import com.teamwork.android.samples.clean.data.injection.module.internal.DataRepoBindingModule;
import com.teamwork.android.samples.clean.data.injection.module.internal.NetworkModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component for dependency injection of classes in the 'sample-data' module (data layer).
 * <p>
 * The {@link Component} extends from {@link DataAccessComponent} so that the required "public" dependencies that need
 * to be exposed to the business layer via a provision method (https://google.github.io/dagger/api/2.14/dagger/Component.html)
 * are declared here.
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
public interface SampleDataComponent extends DataAccessComponent {

    //region data layer internal dependencies

    /* Add here any dependencies which only need to be accessed (manually) from the data layer */

    //endregion

    //region component provider

    @SuppressWarnings("unused")
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    static ComponentProvider getProvider() {
        return ComponentProvider.COMPONENT_PROVIDER;
    }

    @SuppressWarnings("unused")
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    class ComponentProvider {

        private static final ComponentProvider COMPONENT_PROVIDER = new ComponentProvider();

        private volatile SampleDataComponent dataComponent;

        public void setComponent(@NonNull SampleDataComponent component) {
            dataComponent = component;
        }

        public @NonNull SampleDataComponent getComponent() {
            if (dataComponent == null) {
                throw new IllegalStateException("SampleDataComponent not initialized");
            }
            return dataComponent;
        }
    }

    //endregion

}