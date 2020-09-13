package vinova.kane.string.model.interest


import com.google.gson.annotations.SerializedName

data class InterestData(
    @SerializedName("check_user_sellect")
    val checkUserSellect: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("photo")
    val photo: Photo,
    @SerializedName("photoID")
    val photoID: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("trash")
    val trash: Int,
    @SerializedName("updated_at")
    val updatedAt: String
)