package com.teamwork.android.samples.clean.feature1.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.teamwork.android.samples.clean.feature1.R
import javax.inject.Inject

class Feature1ListActivity : AppCompatActivity(), Feature1ListView {

    @Inject
    lateinit var presenter: Feature1ListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature1_list)
        presenter.onViewCreated(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

}