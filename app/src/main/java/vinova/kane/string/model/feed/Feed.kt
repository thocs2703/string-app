package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class Feed(
    @SerializedName("code")
    val code: String,
    @SerializedName("data")
    val `data`: List<FeedData>,
    @SerializedName("message")
    val message: String,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("status")
    val status: Boolean
)