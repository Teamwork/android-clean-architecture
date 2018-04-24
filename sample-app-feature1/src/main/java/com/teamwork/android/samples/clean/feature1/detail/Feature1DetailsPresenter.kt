package com.teamwork.android.samples.clean.feature1.detail

import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.business.feature1.detail.Feature1DetailsInteractor
import com.teamwork.android.samples.clean.core.BasePresenter
import com.teamwork.android.samples.clean.entity.feature1.Entity1
import javax.inject.Inject

class Feature1DetailsPresenter @Inject constructor(private val interactor: Feature1DetailsInteractor)
    : BasePresenter<Feature1DetailsView>() {

    private val callback: Feature1DetailsCallback = Feature1DetailsCallback()

    override fun onViewCreated(view: Feature1DetailsView) {
        super.onViewCreated(view)
        interactor.registerCallback(callback)
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        interactor.unregisterCallback()
    }

}

private class Feature1DetailsCallback : Interactor.Callback<Entity1> {

    override fun onDataLoaded(data: Entity1) {
        TODO("not implemented")
    }

    override fun onDataLoadError(exception: Exception) {
        TODO("not implemented")
    }

}