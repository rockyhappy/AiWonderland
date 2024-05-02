package com.devrachit.aiwonderland.domain.repository

import com.devrachit.aiwonderland.data.remote.dto.CoinDetailsDto
import com.devrachit.aiwonderland.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>
    suspend fun getCoinById(coinId: String) : CoinDetailsDto

}