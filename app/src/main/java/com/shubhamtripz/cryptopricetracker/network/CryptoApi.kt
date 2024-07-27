package com.shubhamtripz.cryptopricetracker.network

import com.shubhamtripz.cryptopricetracker.data.CryptoResponse
import retrofit2.Call
import retrofit2.http.GET

interface CryptoApi {
    @GET("assets")
    fun getCryptos(): Call<CryptoResponse>
}
