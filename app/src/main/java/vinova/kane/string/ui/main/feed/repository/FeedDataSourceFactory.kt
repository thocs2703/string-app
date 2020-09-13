package vinova.kane.string.ui.main.feed.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import vinova.kane.string.model.feed.FeedData
import vinova.kane.string.network.ApiService

class FeedDataSourceFactory(
    private val service: ApiService,
    private val compositeDisposable: CompositeDisposable,
    private val authorization: String)
    : DataSource.Factory<Int, FeedData>() {

    private val feedLiveDataSource = MutableLiveData<FeedDataSource>()

    override fun create(): DataSource<Int, FeedData> {
        val feedDataSource = FeedDataSource(service, compositeDisposable, authorization)
        Log.i("FeedDataSourceFactory", "Created Feed Data Source!")
        feedLiveDataSource.postValue(feedDataSource)
        return feedDataSource
    }
}