import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListViewModel : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Common().baseUrlSearch)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service : ApiServices = retrofit.create(ApiServices::class.java)

    val pokemonsList = MutableLiveData<List<ResultData>>()

    fun getPokemonList(){
        val call = service.getListPokemon(151,0)

        call.enqueue(object : Callback<ApiResponse>{

            override fun onResponse(call: Call<ApiResponse>,response: Response<ApiResponse>) {
                response.body()?.results?.let { list ->
                    pokemonsList.postValue(list)
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                call.cancel()
            }

        })
    }
}