package com.teamwork.android.samples.clean.app.injection;

import com.teamwork.android.samples.clean.app.SampleActivity;
import com.teamwork.android.samples.clean.app.feature2.detail.Feature2DetailsActivity;
import com.teamwork.android.samples.clean.business.injection.module.exported.InteractorsModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        // dependencies from the business module
        InteractorsModule.class
})
public interface ApplicationComponent {

    void inject(SampleActivity activity);

    void inject(Feature2DetailsActivity activity);

}