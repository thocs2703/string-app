package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("address")
    val address: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lat")
    val lat: Float,
    @SerializedName("long")
    val long: Float,
    @SerializedName("photos")
    val photos: List<PhotoX>,
    @SerializedName("placeID")
    val placeID: String,
    @SerializedName("title")
    val title: String
)