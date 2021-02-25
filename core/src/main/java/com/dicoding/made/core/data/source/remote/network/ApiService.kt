package com.dicoding.made.core.data.source.remote.network

import com.dicoding.made.core.data.source.remote.response.ListTeamsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/json/1/search_all_teams.php?l=English%20Premier%20League")
    suspend fun getList(): ListTeamsResponse
}