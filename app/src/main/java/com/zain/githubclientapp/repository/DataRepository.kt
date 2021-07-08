package com.zain.githubclientapp.repository

import com.zain.githubclientapp.model.RepositoryModel
import com.zain.githubclientapp.network.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getRepositoriesList(since: String): RepositoryModel {
        return apiService.getPublicRepositories(since = since)
    }

}
