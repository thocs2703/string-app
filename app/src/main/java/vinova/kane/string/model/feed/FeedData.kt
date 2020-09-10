package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class FeedData(
    @SerializedName("address")
    val address: String,
    @SerializedName("commentCounter")
    val commentCounter: Int,
    @SerializedName("coverImage")
    val coverImage: CoverImage,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isLiked")
    val isLiked: Boolean,
    @SerializedName("isPrivate")
    val isPrivate: Boolean,
    @SerializedName("isSaved")
    val isSaved: Boolean,
    @SerializedName("isString")
    val isString: Boolean,
    @SerializedName("itineraries")
    val itineraries: List<Itinerary>,
    @SerializedName("lat")
    val lat: Int,
    @SerializedName("likeCounter")
    val likeCounter: Int,
    @SerializedName("long")
    val long: Int,
    @SerializedName("photos")
    val photos: List<Photo>,
    @SerializedName("place")
    val place: Place,
    @SerializedName("placeID")
    val placeID: Int,
    @SerializedName("saveCounter")
    val saveCounter: Int,
    @SerializedName("strungCounter")
    val strungCounter: Int,
    @SerializedName("strungFrom")
    val strungFrom: StrungFrom,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("title")
    val title: String,
    @SerializedName("type ")
    val type: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user")
    val user: User,
    @SerializedName("videos")
    val videos: String,
    @SerializedName("websiteUrl")
    val websiteUrl: String,
    @SerializedName("workingHours")
    val workingHours: String
)