package com.imscreed.offers

import android.app.Application
import com.imscreed.offers.di.ApplicationComponent
import com.imscreed.offers.di.NetworkModule
import com.imscreed.offers.di.DaggerApplicationComponent

class OffersApplication : Application() {
    private val appComponent: ApplicationComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent(): ApplicationComponent {
        return DaggerApplicationComponent
            .builder()
            .networkModule(NetworkModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)
}