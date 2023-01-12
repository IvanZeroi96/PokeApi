import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices{

    @GET("pokemon")
    fun getListPokemon(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<ApiResponse>

    @GET("pokemon/{name}")
    fun getDetailPokemon(@Path("name") name: String): Call<Pokemon>
}