package com.teamwork.android.samples.clean.data.access

import com.teamwork.android.samples.clean.entity.BusinessEntity

@Suppress("unused")
/**
 * Basic interface for an asynchronous data result.
 */
interface DataCallback<R : BusinessEntity> {

    fun onSuccess(result: R)

    fun onError(exception: Exception)

}