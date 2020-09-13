package vinova.kane.string.model.interest


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: Url
)