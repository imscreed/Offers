package com.imscreed.offers.base

import androidx.lifecycle.ViewModel
import com.imscreed.offers.OffersApplication
import com.imscreed.offers.di.ApplicationComponent
import com.imscreed.offers.di.DaggerApplicationComponent
import com.imscreed.offers.di.NetworkModule
import com.imscreed.offers.features.offerlist.OfferListViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ApplicationComponent = DaggerApplicationComponent
        .builder()
        .networkModule(NetworkModule(OffersApplication()))
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is OfferListViewModel -> injector.inject(this)
        }
    }
}