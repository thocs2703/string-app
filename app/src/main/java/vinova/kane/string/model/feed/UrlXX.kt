package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class UrlXX(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("thumb")
    val thumb: String
)