package vinova.kane.string.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import vinova.kane.string.model.feed.FeedData
import vinova.kane.string.network.Client
import vinova.kane.string.ui.main.feed.repository.FeedDataSourceFactory
import vinova.kane.string.util.DATA_PER_PAGE

class FeedViewModel: ViewModel() {
    private lateinit var sourceFactory: FeedDataSourceFactory
    private val compositeDisposable = CompositeDisposable()
    private val apiService = Client.getClient()
    lateinit var feedDataPagedList: LiveData<PagedList<FeedData>>

    private var config: PagedList.Config = PagedList.Config.Builder()
        .setPageSize(DATA_PER_PAGE)
        .setEnablePlaceholders(false)
        .build()

    fun getFeed(authorization: String){
        sourceFactory = FeedDataSourceFactory(apiService, compositeDisposable, authorization)
        feedDataPagedList = LivePagedListBuilder<Int, FeedData>(sourceFactory, config).build()
        Log.i("FeedViewModel", "Get Feed")
        Log.d("FeedViewModel", "Authorization: $authorization")
    }

//    fun retry() {
//        sourceFactory.feedLiveDataSource.value?.retry()
//    }
//
//    fun refresh() {
//        sourceFactory.feedLiveDataSource.value!!.invalidate()
//    }
//
//    fun listIsEmpty(): Boolean {
//        return feedDataPagedList.value?.isEmpty() ?: true
//    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}