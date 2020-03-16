package com.imscreed.offers.api

import com.imscreed.offers.model.OffersResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface OffersApi {
    @GET("1fmkuq")
    fun getOffersFromRemoteAsync(): Deferred<Response<OffersResponse>>
}