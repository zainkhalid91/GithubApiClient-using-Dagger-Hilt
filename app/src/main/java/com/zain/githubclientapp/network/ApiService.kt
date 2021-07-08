package com.zain.githubclientapp.network

import com.zain.githubclientapp.model.RepositoryModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(NetworkConstants.URL_REPOSITORIES)
    suspend fun getPublicRepositories(
        @Query("since") since: String
    ): RepositoryModel
}