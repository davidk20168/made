package com.dicoding.made.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Teams(
        val idTeam : String,
        val strTeam : String,
        val strStadium : String,
        val strDescriptionEn : String,
        val strTeamBadge : String,
        val isFavorite : Boolean
) : Parcelable

