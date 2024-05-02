package com.devrachit.aiwonderland.data.remote

import com.devrachit.aiwonderland.data.remote.dto.CoinDetailsDto
import com.devrachit.aiwonderland.data.remote.dto.CoinDto
import retrofit2.http.GET

interface  CoinPaprikaApi {
    @GET("v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(coinId: String): CoinDetailsDto

}