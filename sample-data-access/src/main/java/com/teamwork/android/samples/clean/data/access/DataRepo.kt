package com.teamwork.android.samples.clean.data.access

import androidx.annotation.AnyThread

/**
 * Mock, empty interface for "Repository" components.
 *
 * These are components which are exposed to the business layer, and allow interactors to retrieve data from the data
 * layer.
 *
 * A repository provides an abstraction layer over concrete data source implementations, encapsulates them and provides
 * interfaces for those implementations so that they are easily pluggable and interchangeable.
 */
@AnyThread
interface DataRepo {
}