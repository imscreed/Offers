package com.imscreed.offers.features.offerlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.imscreed.offers.base.BaseViewModel
import com.imscreed.offers.model.Offer
import com.imscreed.offers.repository.OffersRepository
import kotlinx.android.synthetic.main.offer_list_row_item.view.*
import kotlinx.coroutines.launch
import java.util.*
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

    fun sortListByName() {
        _offersLiveData.value?.sortWith(kotlin.Comparator { a, b -> a.name.compareTo(b.name)})
    }

    fun sortByCashback() {
        _offersLiveData.value?.sortWith(kotlin.Comparator { a, b -> b.cash_back.compareTo(a.cash_back)})
    }
}
