package com.dicoding.made.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class TeamsEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam : String,

    @ColumnInfo(name = "strTeam")
    var strTeam : String,

    @ColumnInfo(name = "strStadium")
    var strStadium : String,

    @ColumnInfo(name = "strDescriptionEN")
    var strDescriptionEn : String,

    @ColumnInfo(name = "strTeamBadge")
    var strTeamBadge : String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite : Boolean = false
)