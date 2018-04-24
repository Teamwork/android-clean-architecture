package com.teamwork.android.samples.clean.feature1.list

import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.business.feature1.list.Feature1ListInteractor
import com.teamwork.android.samples.clean.core.BasePresenter
import com.teamwork.android.samples.clean.entity.feature1.Entity1List
import javax.inject.Inject

class Feature1ListPresenter @Inject constructor(private val interactor: Feature1ListInteractor)
    : BasePresenter<Feature1ListView>() {

    private val callback: Feature1ListCallback = Feature1ListCallback()

    override fun onViewCreated(view: Feature1ListView) {
        super.onViewCreated(view)
        interactor.registerCallback(callback)
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        interactor.unregisterCallback()
    }

}

private class Feature1ListCallback : Interactor.Callback<Entity1List> {

    override fun onDataLoaded(data: Entity1List) {
        TODO("not implemented")
    }

    override fun onDataLoadError(exception: Exception) {
        TODO("not implemented")
    }

}