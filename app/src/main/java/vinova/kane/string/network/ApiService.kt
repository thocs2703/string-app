package vinova.kane.string.network

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*
import vinova.kane.string.model.feed.Feed
import vinova.kane.string.model.interest.Interest
import vinova.kane.string.model.user.UserData
import vinova.kane.string.model.user.UserResponse

interface ApiService {
    @FormUrlEncoded
    @POST("users-register-email")
    fun registerUser(
        @Field("username") username: String,
        @Field("name") name: String,
        @Field("date_of_birth") dayOfBirth: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirm_password") confirmPassword: String
    ): Single<UserResponse>

    @FormUrlEncoded
    @POST("resend-email")
    fun verifyEmail(
        @Field("code") code: String
    ): Single<UserResponse>

    @FormUrlEncoded
    @POST("users-login")
    fun loginUserByEmail(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("fcm_token") fcmToken: String
    ): Single<UserResponse>

    @GET("feed")
    fun getFeed(
        @Query("page") page: Int,
        @Query("current_per_page") currentPerPage: Int,
        @Header("Authorization") authorization: String
    ): Single<Feed>

    @GET("interest-categories-list")
    fun getListInterest(
        @Header("Authorization") authorization: String
    ): Single<Interest>

    @PUT("users-interest-categories-select")
    fun putInterest(
        @Header("Authorization") authorization: String,
        @Query("lists_interest[]") listsInterest: ArrayList<Int>
    ): Single<UserResponse>
}