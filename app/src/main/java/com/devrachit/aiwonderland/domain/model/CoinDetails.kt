package com.devrachit.aiwonderland.domain.model

import com.devrachit.aiwonderland.data.remote.dto.TeamMember

data class CoinDetails(
    val coinId:String,
    val name : String,
    val description : String,
    val symbol : String,
    val rank : Int,
    val isActive : Boolean,
    val tags : List<String>,
    val team : List<TeamMember>
)
