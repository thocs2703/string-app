package vinova.kane.string.ui.main.feed.repository

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vinova.kane.string.model.feed.FeedData
import vinova.kane.string.network.ApiService
import vinova.kane.string.ui.start.StartActivity
import vinova.kane.string.util.SaveSharedPreference
import vinova.kane.string.util.StringApplication

class FeedDataSource(
    private val service: ApiService,
    private val compositeDisposable: CompositeDisposable,
    private val authorization: String)
    : PageKeyedDataSource<Int, FeedData>(){

    private val page = FIRST_PAGE

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, FeedData>
    ) {
        compositeDisposable.add(
            service.getFeed(page, PAGE_SIZE, authorization)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    callback.onResult(it.data, null, page + 1)
                    Log.i("FeedDataSource", "Success!")
                },{
                    Log.d("FeedDataSource", "Message: ${it.message}")
                    val context: Context = StringApplication.applicationContext()
                    SaveSharedPreference().setLoggedIn(context, false)
                    val intent = Intent(context, StartActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(context, intent, null)
                })
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, FeedData>) {
        compositeDisposable.add(
            service.getFeed(params.key, PAGE_SIZE, authorization)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    callback.onResult(it.data, params.key + 1)
                },{
                    Log.i("FeedDataSource", "Message load after: ${it.message}")
                })
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, FeedData>) {

    }

    companion object{
        private const val FIRST_PAGE = 1
        private const val PAGE_SIZE = 25
    }
}