package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("badgeID")
    val badgeID: Int,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("currentLocation")
    val currentLocation: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("facebookID")
    val facebookID: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("notificationSettings")
    val notificationSettings: NotificationSettings,
    @SerializedName("profilePhoto")
    val profilePhoto: String,
    @SerializedName("trash")
    val trash: Boolean,
    @SerializedName("type")
    val type: String,
    @SerializedName("userID")
    val userID: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
)