package com.teamwork.android.samples.clean.business.injection;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.teamwork.android.samples.business.injection.module.bridge.DataAccessLayerBridgeModule;
import com.teamwork.android.samples.business.injection.module.exported.DataRepoModule;
import com.teamwork.android.samples.clean.business.feature1.detail.Feature1DetailsInteractor;
import com.teamwork.android.samples.clean.business.feature1.list.Feature1ListInteractor;
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractor;
import com.teamwork.android.samples.clean.business.injection.module.internal.InteractorsBindingModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        InteractorsBindingModule.class,
        DataRepoModule.class,
        // data access layer dependencies
        DataAccessLayerBridgeModule.class
})
public interface SampleBusinessComponent {

    /*
     * Provision methods for public interactors that need to be exposed to the presentation layer.
     * Any other interactor implementation which is not declared here will only be accessible from the other modules.
     */

    Feature1DetailsInteractor feature1DetailsInteractor();

    Feature1ListInteractor feature1ListInteractor();

    Feature2DetailsInteractor feature2DetailsInteractor();

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

        private volatile SampleBusinessComponent businessComponent;

        public void setComponent(@NonNull SampleBusinessComponent component) {
            businessComponent = component;
        }

        public @NonNull SampleBusinessComponent getComponent() {
            if (businessComponent == null) {
                throw new IllegalStateException("SampleBusinessComponent not initialized");
            }
            return businessComponent;
        }
    }

    //endregion

}