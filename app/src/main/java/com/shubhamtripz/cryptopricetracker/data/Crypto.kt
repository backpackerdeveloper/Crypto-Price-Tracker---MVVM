package com.shubhamtripz.cryptopricetracker.data

data class CryptoResponse(
    val data: List<Crypto>
)

data class Crypto(
    val name: String,
    val priceUsd: String,
    val rank: String,
    val explorer: String
)
