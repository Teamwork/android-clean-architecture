package com.teamwork.android.samples.clean.business.internal

import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.entity.feature2.Entity2

/**
 * This [Interactor] is only mean to be used within the `business` layer, so it can be declared as `internal`.
 */
internal interface InternalInteractor : Interactor<Entity2, Interactor.Callback<Entity2>> {

    fun initialize()

}