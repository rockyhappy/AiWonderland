package com.devrachit.aiwonderland.domain.use_case.get_coins


import com.devrachit.aiwonderland.common.Resource
import com.devrachit.aiwonderland.data.remote.dto.toCoin
import com.devrachit.aiwonderland.domain.model.Coin
import com.devrachit.aiwonderland.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
        catch(e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }

    }

}