package com.imscreed.offers.repository

import com.imscreed.offers.api.OffersApi
import com.imscreed.offers.base.BaseRepository
import com.imscreed.offers.model.Offer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OffersRepository
@Inject constructor(private val offerApi: OffersApi) : BaseRepository() {

    suspend fun fetchOffersFromRemote(): MutableList<Offer>? {
        val response = secureApiCall(
            call = {
                withContext(Dispatchers.IO) {
                    offerApi.getOffersFromRemoteAsync().await()
                }
            },
            errorMessage = "Error Fetching Offers"
        )

        return response?.offers?.toMutableList()
    }
}
