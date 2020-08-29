package vinova.kane.string.model


import com.google.gson.annotations.SerializedName

data class NotificationSettings(
    @SerializedName("comments")
    val comments: String,
    @SerializedName("likes")
    val likes: String,
    @SerializedName("new_followes")
    val newFollowes: String,
    @SerializedName("post_saves")
    val postSaves: String,
    @SerializedName("string")
    val string: String
)