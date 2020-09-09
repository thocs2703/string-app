package vinova.kane.string.network

import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import vinova.kane.string.model.feed.Feed
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
        @Field("page") page: String,
        @Field("current_per_page") current_per_page: String,
        @Field("Authorization") Authorization: String
    ): Single<Feed>
}