package vinova.kane.string.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import vinova.kane.string.model.feed.Feed
import vinova.kane.string.network.Client

class FeedViewModel: ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = Client.getClient()

    val feedData: MutableLiveData<Feed> = MutableLiveData()

    fun getFeed(){

    }
}