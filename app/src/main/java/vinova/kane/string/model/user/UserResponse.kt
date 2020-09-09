package vinova.kane.string.model.user


import com.google.gson.annotations.SerializedName
import vinova.kane.string.model.user.Data

data class UserResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
)