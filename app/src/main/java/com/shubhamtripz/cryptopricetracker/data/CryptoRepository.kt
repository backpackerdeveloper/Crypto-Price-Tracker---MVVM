package com.shubhamtripz.cryptopricetracker.data

import com.shubhamtripz.cryptopricetracker.network.CryptoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptoRepository {
    private val api: CryptoApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coincap.io/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(CryptoApi::class.java)
    }

    fun getCryptos() = api.getCryptos() // Return Call<CryptoResponse>
}
