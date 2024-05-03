package com.devrachit.aiwonderland.presentation.coin_details

import com.devrachit.aiwonderland.domain.model.CoinDetails

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)