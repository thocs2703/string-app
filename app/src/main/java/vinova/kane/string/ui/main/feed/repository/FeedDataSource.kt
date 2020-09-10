package vinova.kane.string.ui.main.feed.repository

import android.util.Log
import androidx.paging.PageKeyedDataSource
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import vinova.kane.string.model.feed.FeedData
import vinova.kane.string.network.ApiService
import java.util.concurrent.TimeUnit

class FeedDataSource(
    private val service: ApiService,
    private val compositeDisposable: CompositeDisposable,
    private val authorization: String)
    : PageKeyedDataSource<String, FeedData>(){

    private val page = FIRST_PAGE

    private var retryCompletable: Completable? = null

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, FeedData>
    ) {
        compositeDisposable.add(
            service.getFeed(page.toString(), PER_PAGE, authorization)
                .subscribe({
                    callback.onResult(it.data, 0.toString(), (page + 1).toString())
                    Log.d("FeedDataSource", "Callback data: ${it.data}")
                },{
                    setRetry(Action { loadInitial(params, callback) })
                })
        )
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, FeedData>) {
        compositeDisposable.add(
            service.getFeed(params.key, PER_PAGE, authorization)
                .delay(1000, TimeUnit.MILLISECONDS)
                .subscribe({
                    callback.onResult(it.data, params.key + 1)
                    Log.d("FeedDataSource", "Callback data at page ${params.key + 1}: ${it.data}")
                },{
                    setRetry(Action { loadAfter(params, callback) })
                })
        )
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, FeedData>) {

    }

    fun retry() {
        if (retryCompletable != null) {
            compositeDisposable.add(retryCompletable!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
        }
    }

    private fun setRetry(action: Action?) {
        retryCompletable = if (action == null) null else Completable.fromAction(action)
    }

    companion object{
        private const val FIRST_PAGE = 1
        private const val PER_PAGE = "10"
    }
}