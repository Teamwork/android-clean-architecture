package com.teamwork.android.samples.clean.feature1.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.teamwork.android.samples.clean.feature1.R
import javax.inject.Inject

/**
 * TODO: handle Dagger injection with a Subcomponent in the feature module
 */
class Feature1DetailsActivity : AppCompatActivity(), Feature1DetailsView {

    @Inject
    lateinit var presenter: Feature1DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature1)
        presenter.onViewCreated(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

}