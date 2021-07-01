package com.nitb.githubclientapp.repository

import com.nitb.githubclientapp.model.RepositoryModel
import com.nitb.githubclientapp.network.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getRepositoriesList(since: String): RepositoryModel {
        return apiService.getPublicRepositories(since = since)
    }

}
