package vinova.kane.string.ui.start.interest.repository

import android.util.Log
import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vinova.kane.string.model.interest.InterestData
import vinova.kane.string.network.ApiService

class InterestDataSource(
    private val service: ApiService,
    private val compositeDisposable: CompositeDisposable,
    private val authorization: String)
    : PageKeyedDataSource<Int, InterestData>() {

    private val page = FIRST_PAGE

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, InterestData>
    ) {
        compositeDisposable.add(
            service.getListInterest(authorization)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    callback.onResult(it.data, null, page + 1)
                    Log.i("InterestDataSource", "Success!")
                }, {
                    Log.d("InterestDataSource", "Message: ${it.message}")
                })
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, InterestData>) {

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, InterestData>) {

    }

    companion object {
        private const val FIRST_PAGE = 1
    }
}