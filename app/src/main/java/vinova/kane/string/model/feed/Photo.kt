package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("file_content_type")
    val fileContentType: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: UrlXX
)