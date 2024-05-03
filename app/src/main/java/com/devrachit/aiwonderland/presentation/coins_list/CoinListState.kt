package com.devrachit.aiwonderland.presentation.coins_list

import com.devrachit.aiwonderland.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)