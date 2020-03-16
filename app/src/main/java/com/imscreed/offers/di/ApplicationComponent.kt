package com.imscreed.offers.di

import androidx.core.view.KeyEventDispatcher
import com.imscreed.offers.OffersApplication
import com.imscreed.offers.features.offerlist.OfferListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class]
)
interface ApplicationComponent {
    fun inject(application: OffersApplication)
    fun inject(offerListViewModel: OfferListViewModel)

    @Component.Builder
    interface Builder {
        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): ApplicationComponent
    }
}