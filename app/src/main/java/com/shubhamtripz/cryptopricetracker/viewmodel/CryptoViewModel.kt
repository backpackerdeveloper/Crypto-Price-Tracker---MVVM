package com.shubhamtripz.cryptopricetracker.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shubhamtripz.cryptopricetracker.data.Crypto
import com.shubhamtripz.cryptopricetracker.data.CryptoRepository
import com.shubhamtripz.cryptopricetracker.data.CryptoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoViewModel : ViewModel() {
    private val repository = CryptoRepository()
    private val _cryptos = MutableLiveData<List<Crypto>>()
    val cryptos: LiveData<List<Crypto>>
        get() = _cryptos

    init {
        fetchCryptos()
    }

    private fun fetchCryptos() {
        repository.getCryptos().enqueue(object : Callback<CryptoResponse> {
            override fun onResponse(call: Call<CryptoResponse>, response: Response<CryptoResponse>) {
                if (response.isSuccessful) {
                    _cryptos.value = response.body()?.data
                    Log.d("CryptoViewModel", "Cryptos fetched: ${response.body()?.data}")
                } else {
                    Log.e("CryptoViewModel", "Failed to fetch cryptos: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<CryptoResponse>, t: Throwable) {
                Log.e("CryptoViewModel", "Error fetching cryptos", t)
            }
        })
    }
}
