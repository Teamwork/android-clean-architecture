package com.teamwork.android.samples.clean.core;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * The Presenter is the orchestrator of the View. It reacts to lifecycle events and user actions, it manages the
 * user-modified state, it triggers data loading and receives (and manipulates) the data coming from the business layer
 * and passes it on to the View.
 * <p>
 * <b>Note:</b> as the majority of base components in this sample app, this class is not comprehensive and it's only
 * used as a demonstration of a more complex real implementation.
 */
@UiThread
@ParametersAreNonnullByDefault
public class BasePresenter<V> {

    /**
     * This field is not marked as {@link Nullable} as it would force subclasses to perform a null check at every
     * access. The base presenter delegates to the subclass, depending on the lifecycle state, the need to perform such
     * check.
     */
    protected V view;

    @CallSuper
    public void onViewCreated(@NonNull V view) {
        this.view = view;
    }

    @CallSuper
    public void onViewDestroyed() {
        view = null;
    }

}