package com.dicoding.made.core.utils

import com.dicoding.made.core.data.source.local.entity.TeamsEntity
import com.dicoding.made.core.data.source.remote.response.TeamsResponse
import com.dicoding.made.core.domain.model.Teams

object DataMapper {
    fun mapResponsesToEntities(input : List<TeamsResponse>) : List<TeamsEntity> {
        val teamsList = ArrayList<TeamsEntity>()
        input.map {
        val teams = TeamsEntity(
            idTeam = it.idTeam,
            strTeam = it.strTeam,
            strStadium = it.strStadium,
            strDescriptionEn = it.strDescriptionEn,
            strTeamBadge = it.strTeamBadge
        )
            teamsList.add(teams)
        }
        return teamsList
    }

    fun mapEntitiesToDomain(input : List<TeamsEntity>) : List<Teams> =
            input.map {
                Teams(
                        idTeam = it.idTeam,
                        strTeam = it.strTeam,
                        strStadium = it.strStadium,
                        strDescriptionEn = it.strDescriptionEn,
                        strTeamBadge = it.strTeamBadge,
                        isFavorite = it.isFavorite
                )
            }

    fun mapDomainToEntity(input : Teams) = TeamsEntity(
            idTeam = input.idTeam,
            strTeam = input.strTeam,
            strStadium = input.strStadium,
            strDescriptionEn = input.strDescriptionEn,
            strTeamBadge = input.strTeamBadge,
            isFavorite = input.isFavorite
    )

}