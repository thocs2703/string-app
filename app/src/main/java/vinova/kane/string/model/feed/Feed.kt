package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class Feed(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("status")
    val status: Boolean
)