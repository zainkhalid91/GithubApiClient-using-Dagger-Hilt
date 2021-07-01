package com.nitb.githubclientapp.usecase

import com.nitb.githubclientapp.model.RepositoryModel
import com.nitb.githubclientapp.network.ResultData
import com.nitb.githubclientapp.repository.DataRepository
import javax.inject.Inject

class DataUseCase @Inject constructor(private val dataRepository: DataRepository) {
    suspend fun getRepositoriesList(since: String): ResultData<RepositoryModel> {
        val repositoryModel = dataRepository.getRepositoriesList(since = since)

        return when (repositoryModel.isNotEmpty()) {
            true -> {
                ResultData.Success(repositoryModel)
            }
            else -> {
                ResultData.Failure()
            }
        }

    }

}