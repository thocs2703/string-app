package vinova.kane.string.model.user


import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: UserData,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
)