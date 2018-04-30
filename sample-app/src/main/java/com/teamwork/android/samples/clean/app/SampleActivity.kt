package com.teamwork.android.samples.clean.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.teamwork.android.samples.clean.feature1.detail.Feature1DetailsPresenter
import com.teamwork.android.samples.clean.feature1.detail.Feature1DetailsView
import com.teamwork.android.samples.clean.feature1.list.Feature1ListPresenter
import com.teamwork.android.samples.clean.feature1.list.Feature1ListView
import kotlinx.android.synthetic.main.activity_sample.*
import javax.inject.Inject

class SampleActivity : AppCompatActivity(), Feature1ListView, Feature1DetailsView {

    @Inject
    lateinit var presenter: Feature1ListPresenter

    @Inject
    lateinit var detailsPresenter: Feature1DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SampleApplication.getAppComponent().inject(this)

        setContentView(R.layout.activity_sample)
        setSupportActionBar(toolbar)

        presenter.onViewCreated(this)
        detailsPresenter.onViewCreated(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
        detailsPresenter.onViewDestroyed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_sample, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}