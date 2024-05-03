package com.devrachit.aiwonderland.presentation.coin_details

import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.devrachit.aiwonderland.common.Constants
import com.devrachit.aiwonderland.common.Resource
import com.devrachit.aiwonderland.domain.use_case.get_coin.GetCoinUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}