package com.teamwork.android.samples.clean.entity

/**
 * A business entity is an enterprise-wide critical business rule. It is high level, changes infrequently and it’s
 * (possibly) shared across applications. An entity defines the data representation and the logic on how to manipulate
 * this data, and exposes both to the interactors.
 *
 * Entities should not load data, nor be provided with framework implementations, application-specific rules or
 * presentation details.
 */
interface BusinessEntity