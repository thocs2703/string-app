package vinova.kane.string.ui.start.interest.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import vinova.kane.string.model.interest.InterestData
import vinova.kane.string.network.ApiService

class InterestDataSourceFactory(
    private val service: ApiService,
    private val compositeDisposable: CompositeDisposable,
    private val authorization: String)
    : DataSource.Factory<Int, InterestData>() {

    private val interestLiveDataSource = MutableLiveData<InterestDataSource>()

    override fun create(): DataSource<Int, InterestData> {
        val interestDataSource = InterestDataSource(service, compositeDisposable, authorization)
        Log.i("InterestDTSource", "Created Interest Data Source!")
        interestLiveDataSource.postValue(interestDataSource)
        return interestDataSource
    }
}