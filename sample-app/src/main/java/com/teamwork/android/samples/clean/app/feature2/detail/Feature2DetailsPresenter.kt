package com.teamwork.android.samples.clean.app.feature2.detail

import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractor
import com.teamwork.android.samples.clean.business.injection.BusinessComponent
import com.teamwork.android.samples.clean.core.BasePresenter
import com.teamwork.android.samples.clean.entity.feature2.Entity2
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import javax.inject.Named

class Feature2DetailsPresenter @Inject constructor(
        private val interactor: Feature2DetailsInteractor,

        @Named(BusinessComponent.GLOBAL_COMPUTATION_EXECUTOR)
        private val computationExecutor: ExecutorService

        // private val internalInteractor: InternalInteractor // this (and rightly so) doesn't even compile!
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
        computationExecutor.submit { /* do stuff here */ }
    }

    override fun onDataLoadError(exception: Exception) {
        TODO("not implemented")
    }

}