package vinova.kane.string.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import vinova.kane.string.model.interest.InterestData
import vinova.kane.string.network.Client
import vinova.kane.string.ui.start.interest.repository.InterestDataSourceFactory

class InterestViewModel: ViewModel() {
    private lateinit var sourceFactory: InterestDataSourceFactory
    private val compositeDisposable = CompositeDisposable()
    private val apiService = Client.getClient()
    lateinit var interestDataPagedList: LiveData<PagedList<InterestData>>

    private var config: PagedList.Config = PagedList.Config.Builder()
        .setPageSize(25)
        .setEnablePlaceholders(false)
        .build()

    fun getListInterests(authorization: String){
        sourceFactory = InterestDataSourceFactory(apiService, compositeDisposable, authorization)
        interestDataPagedList = LivePagedListBuilder<Int, InterestData>(sourceFactory, config).build()
        Log.i("FeedViewModel", "Get Feed")
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}