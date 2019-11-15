package com.teamwork.android.samples.clean.app.feature2.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.teamwork.android.samples.clean.app.R;
import com.teamwork.android.samples.clean.app.SampleApplication;

import javax.inject.Inject;

public class Feature2DetailsActivity extends AppCompatActivity implements Feature2DetailsView {

    @Inject
    Feature2DetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SampleApplication.Companion.getAppComponent().inject(this);

        setContentView(R.layout.activity_feature2_details);
        presenter.onViewCreated(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onViewDestroyed();
    }

}