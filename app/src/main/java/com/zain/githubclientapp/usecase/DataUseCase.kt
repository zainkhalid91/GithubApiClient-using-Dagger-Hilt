package com.zain.githubclientapp.usecase

import com.zain.githubclientapp.model.RepositoryModel
import com.zain.githubclientapp.network.ResultData
import com.zain.githubclientapp.repository.DataRepository
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