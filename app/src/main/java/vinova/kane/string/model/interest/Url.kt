package vinova.kane.string.model.interest


import com.google.gson.annotations.SerializedName

data class Url(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("thumb")
    val thumb: String
)