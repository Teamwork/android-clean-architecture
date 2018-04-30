package com.teamwork.android.samples.clean.app.injection;

import com.teamwork.android.samples.clean.app.SampleActivity;
import com.teamwork.android.samples.clean.app.feature2.detail.Feature2DetailsActivity;
import com.teamwork.android.samples.clean.business.injection.module.bridge.BusinessLayerModule;
import com.teamwork.android.samples.clean.business.injection.module.exported.InteractorsModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        // business layer interactors
        InteractorsModule.class,
        // business layer module component
        BusinessLayerModule.class
})
public interface ApplicationComponent {

    void inject(SampleActivity activity);

    void inject(Feature2DetailsActivity activity);

}