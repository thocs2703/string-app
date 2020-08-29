package vinova.kane.string.repository

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vinova.kane.string.model.UserResponse
import vinova.kane.string.network.Client

object UserRepository {
    var verificationEmail: String ?= null

//    fun registerUser(
//        username: String,
//        name: String,
//        dayOfBirth: String,
//        email: String,
//        password: String,
//        confirmPassword: String,
//        callBack: (UserResponse) -> Unit){
//        val call = Client.getClient().registerUser(username, name, dayOfBirth, email, password, confirmPassword)
//        call.enqueue(object : Callback<UserResponse> {
//            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//                Log.d("UserRepository", "Failure: ${t.message}")
//            }
//
//            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
//                response.body().let {
//                    verificationEmail = it?.data?.email
//                    callBack.invoke(it!!)
//                }
//            }
//
//        })
//    }
}