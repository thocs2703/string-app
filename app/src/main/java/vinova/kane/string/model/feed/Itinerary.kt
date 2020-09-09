package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class Itinerary(
    @SerializedName("id")
    val id: Int,
    @SerializedName("orderNo")
    val orderNo: Int,
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("poiID ")
    val poiID: Int,
    @SerializedName("title")
    val title: String
)