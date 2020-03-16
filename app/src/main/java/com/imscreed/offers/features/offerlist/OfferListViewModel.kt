package com.imscreed.offers.features.offerlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.imscreed.offers.base.BaseViewModel
import com.imscreed.offers.model.Offer
import com.imscreed.offers.repository.OffersRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class OfferListViewModel : BaseViewModel() {
    @Inject
    lateinit var repository: OffersRepository

    init {
        fetchOffersFromRepository()
    }

    val _offersLiveData = MutableLiveData<MutableList<Offer>>()
    val offers: LiveData<MutableList<Offer>>
        get() = _offersLiveData

    private fun fetchOffersFromRepository() {
        viewModelScope.launch {
            val offerList = repository.fetchOffersFromRemote()
            _offersLiveData.postValue(offerList)
        }
    }
}
