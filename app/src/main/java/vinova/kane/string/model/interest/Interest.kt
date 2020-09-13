package vinova.kane.string.model.interest


import com.google.gson.annotations.SerializedName

data class Interest(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<InterestData>,
    @SerializedName("message")
    val message: String,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("status")
    val status: Boolean
)