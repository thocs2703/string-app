package vinova.kane.string.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vinova.kane.string.model.interest.Interest
import vinova.kane.string.model.user.UserResponse
import vinova.kane.string.network.Client

class InterestViewModel: ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = Client.getClient()

    val interest = MutableLiveData<Interest>()
    val putInterest = MutableLiveData<UserResponse>()

    fun getListInterest(authorization: String) {
        compositeDisposable.add(
            apiService.getListInterest(authorization)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    interest.value = it
                    Log.d("InterestViewModel", "Success, data: ${it.data}")
                }, {
                    Log.d("InterestViewModel", "Message: ${it.message}")
                })
        )
    }

    fun putListInterest(accessToken: String, listsInterest: ArrayList<Int>) {
        compositeDisposable.add(
            apiService.putInterest(accessToken, listsInterest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    putInterest.value = it
                }, {
                    Log.d("InterestViewModel", "Message: ${it.message}")
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}