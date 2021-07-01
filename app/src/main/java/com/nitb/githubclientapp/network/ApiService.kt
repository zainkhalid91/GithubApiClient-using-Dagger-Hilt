package com.nitb.githubclientapp.network

import com.nitb.githubclientapp.model.RepositoryModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(NetworkConstants.URL_REPOSITORIES)
    suspend fun getPublicRepositories(
        @Query("since") since: String
    ): RepositoryModel
}