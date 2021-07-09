package com.zain.githubclientapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.zain.githubclientapp.adapters.RepositoriesAdapter
import com.zain.githubclientapp.databinding.ActivityMainBinding
import com.zain.githubclientapp.model.RepositoryModel
import com.zain.githubclientapp.network.ResultData
import dagger.hilt.android.AndroidEntryPoint
import viewmodel.MainViewModel


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var repositoriesAdapter: RepositoriesAdapter
    private val repositoryObserver = Observer<ResultData<RepositoryModel?>> { resultData ->
        binding.apply {
            when (resultData) {
                is ResultData.Loading -> {
                    progressIndicator.show()
                }
                is ResultData.Success -> {
                    progressIndicator.hide()
                    val repositoryModel = resultData.data
                    repositoriesAdapter.submitList(repositoryModel)
                }
                is ResultData.Failure -> {
                    progressIndicator.hide()
                }
                is ResultData.Exception -> {
                    progressIndicator.hide()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        repositoriesAdapter = RepositoriesAdapter()

        binding.apply {
            recyclerViewRepositories.adapter = repositoriesAdapter
            swipeRefresh.setOnRefreshListener(this@MainActivity)

            getDataAndSubscribeEvent()
        }
    }

    private fun getDataAndSubscribeEvent() {
        val repoLiveData = mainViewModel.getRepositoriesList(since = "20")
        repoLiveData.observe(this, repositoryObserver)

    }

    override fun onRefresh() {
        binding.swipeRefresh.isRefreshing = false
        getDataAndSubscribeEvent()
    }
}