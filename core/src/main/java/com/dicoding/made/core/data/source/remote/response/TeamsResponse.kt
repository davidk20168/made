package com.dicoding.made.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamsResponse (
        @field:SerializedName("idTeam")
        val idTeam:String,

        @field:SerializedName("strTeam")
        val strTeam: String,

        @field:SerializedName("strStadium")
        val strStadium : String,

        @field:SerializedName("strDescriptionEN")
        val strDescriptionEn : String,

        @field:SerializedName("strTeamBadge")
        val strTeamBadge : String

        )