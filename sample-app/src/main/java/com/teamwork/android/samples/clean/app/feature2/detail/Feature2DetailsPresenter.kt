package com.teamwork.android.samples.clean.app.feature2.detail

import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractor
import com.teamwork.android.samples.clean.core.BasePresenter
import com.teamwork.android.samples.clean.entity.feature2.Entity2
import javax.inject.Inject

class Feature2DetailsPresenter @Inject constructor(
        private val interactor: Feature2DetailsInteractor//,

        // @Named(SampleBusinessComponent.GLOBAL_COMPUTATION_EXECUTOR) // TODO
        // private val computationExecutor: ExecutorService
) : BasePresenter<Feature2DetailsView>(), Interactor.Callback<Entity2> {

    override fun onViewCreated(view: Feature2DetailsView) {
        super.onViewCreated(view)
        interactor.registerCallback(this)
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        interactor.unregisterCallback()
    }

    override fun onDataLoaded(data: Entity2) {
        TODO("not implemented")
    }

    override fun onDataLoadError(exception: Exception) {
        TODO("not implemented")
    }

}