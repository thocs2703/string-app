package vinova.kane.string.model.user


import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("badge")
    val badge: Any,
    @SerializedName("bio")
    val bio: Any,
    @SerializedName("code")
    val code: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("currentLocation")
    val currentLocation: Any,
    @SerializedName("date_of_birth")
    val dateOfBirth: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("facebookID")
    val facebookID: Any,
    @SerializedName("gender")
    val gender: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("is_first_time")
    val isFirstTime: Boolean,
    @SerializedName("isLoginFirst")
    val isLoginFirst: Boolean,
    @SerializedName("isNewUser")
    val isNewUser: Boolean,
    @SerializedName("isSuperUser")
    val isSuperUser: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("notificationSettings")
    val notificationSettings: NotificationSettings,
    @SerializedName("numberOfLogin")
    val numberOfLogin: Int,
    @SerializedName("profilePhoto")
    val profilePhoto: Any,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("trash")
    val trash: Boolean,
    @SerializedName("type")
    val type: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("wanderlust_details")
    val wanderlustDetails: Any,
    @SerializedName("website")
    val website: Any
)