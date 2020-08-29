package vinova.kane.string.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vinova.kane.string.model.UserResponse
import vinova.kane.string.network.Client

class AuthViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = Client.getClient()

    val registerResponse: MutableLiveData<UserResponse> = MutableLiveData()
    val dataLoginResponse: MutableLiveData<UserResponse> = MutableLiveData()

    fun registerUser(
        username: String,
        name: String,
        dayOfBirth: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        compositeDisposable.add(
            apiService.registerUser(username, name, dayOfBirth, email, password, confirmPassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    registerResponse.value = it
                }, {
                    Log.d("RegisterViewModel", "Register Failure: ${it.message}")
                })
        )
    }

    fun loginUserByEmail(
        email: String,
        password: String,
        fcmToken: String
    ) {
        compositeDisposable.add(
            apiService.loginUserByEmail(email, password, fcmToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    dataLoginResponse.value = it
                }, {
                    Log.d("RegisterViewModel", "Login Failure: ${it.message}")
                })
        )
    }


}