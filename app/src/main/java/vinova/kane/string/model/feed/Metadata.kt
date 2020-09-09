package vinova.kane.string.model.feed


import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("current_per_page")
    val currentPerPage: Int,
    @SerializedName("next_page")
    val nextPage: Int,
    @SerializedName("prev_pages")
    val prevPages: Int,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)