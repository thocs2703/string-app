package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class Videos(
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("thumbs")
    val thumbs: String,
    @SerializedName("url")
    val url: String
)