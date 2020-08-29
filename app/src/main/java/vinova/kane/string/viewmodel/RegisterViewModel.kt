package vinova.kane.string.viewmodel

import android.util.Log
import androidx.lifecycle.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vinova.kane.string.model.Data
import vinova.kane.string.model.UserResponse
import vinova.kane.string.network.Client
import vinova.kane.string.repository.UserRepository

class RegisterViewModel(private val repository: UserRepository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = Client.getClient()

    private val registerResponse: MutableLiveData<UserResponse> = MutableLiveData()
    private val dataLoginResponse: MutableLiveData<UserResponse> = MutableLiveData()

    val registerMessage: LiveData<String> = Transformations.map(registerResponse) {
        it.message
    }

    val registerStatus: LiveData<Boolean> = Transformations.map(registerResponse) {
        it.status
    }

    val registerData: LiveData<Data> = Transformations.map(registerResponse) {
        it.data
    }

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
    ){
        compositeDisposable.add(
            apiService.loginUserByEmail(email, password, fcmToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    dataLoginResponse.value = it
                },{
                    Log.d("RegisterViewModel", "Login Failure: ${it.message}")
                })
        )

    }



    class RegisterViewModelFactory(private val repository: UserRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return RegisterViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}