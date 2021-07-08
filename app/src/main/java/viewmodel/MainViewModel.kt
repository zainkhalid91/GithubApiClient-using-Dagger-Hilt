package viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zain.githubclientapp.model.RepositoryModel
import com.zain.githubclientapp.network.ResultData
import com.zain.githubclientapp.usecase.DataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataUseCase: DataUseCase
) : ViewModel() {
    fun getRepositoriesList(since: String): LiveData<ResultData<RepositoryModel?>> {
        return flow {
            emit(ResultData.Loading())
            try {
                emit(dataUseCase.getRepositoriesList(since = since))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ResultData.Exception())
            }
        }.asLiveData()
    }

}