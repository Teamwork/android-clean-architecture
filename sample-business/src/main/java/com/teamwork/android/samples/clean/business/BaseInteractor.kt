package com.teamwork.android.samples.clean.business

import com.teamwork.android.samples.clean.entity.BusinessEntity

abstract class BaseInteractor<T : BusinessEntity, C : Interactor.Callback<T>> : Interactor<T, C> {

    var callback: C? = null

    override fun registerCallback(callback: C) {
        this.callback = callback
    }

    override fun unregisterCallback() {
        this.callback = null
    }

}