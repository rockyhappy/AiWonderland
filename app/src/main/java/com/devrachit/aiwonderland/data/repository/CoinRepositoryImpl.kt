package com.devrachit.aiwonderland.data.repository

import com.devrachit.aiwonderland.data.remote.CoinPaprikaApi
import com.devrachit.aiwonderland.data.remote.dto.CoinDetailsDto
import com.devrachit.aiwonderland.data.remote.dto.CoinDto
import com.devrachit.aiwonderland.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api  :CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins() : List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId : String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }

}