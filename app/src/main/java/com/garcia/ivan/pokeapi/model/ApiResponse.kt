import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiResponse (
    @Expose @SerializedName("count") val count: Int,
    @Expose @SerializedName("next") val next: String,
    @Expose @SerializedName("previous") val previous: String,
    @Expose @SerializedName("results") val results: List<ResultData>

)

data class ResultData (
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String,
    var position : Int = 1
)