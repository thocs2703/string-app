package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class StrungFrom(
    @SerializedName("id")
    val id: Int,
    @SerializedName("profilePhoto")
    val profilePhoto: String,
    @SerializedName("username")
    val username: String
)