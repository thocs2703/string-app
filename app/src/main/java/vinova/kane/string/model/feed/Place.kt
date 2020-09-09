package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("address")
    val address: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lat")
    val lat: Int,
    @SerializedName("long")
    val long: Int,
    @SerializedName("photos")
    val photos: List<PhotoX>,
    @SerializedName("placeID")
    val placeID: Int,
    @SerializedName("title")
    val title: String
)