package gt.uvg.pokelist.view
import android.util.Log
import com.squareup.moshi.Json
import gt.uvg.pokelist.repository.PokemonApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


data class PokemonPi(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val  ref: String,


) {
    val filteredref = ref.replace("https://pokeapi.co/api/v2/","")
    var details =  PokemonSprites("aaaa","","","")
    val det = PokemonApi.service.getPokeData(filteredref).enqueue(object : Callback<PokemonDetailedResponse> {
        override fun onResponse(
            call: Call<PokemonDetailedResponse>,
            response: Response<PokemonDetailedResponse>
        ) {
            if(response.isSuccessful){
                val temp = response.body()?.sprites
                temp?.let { details = it}
            }
        }

        override fun onFailure(call: Call<PokemonDetailedResponse>, t: Throwable) {
            Log.d("FAILURE",""+t.message)
        }

    })
    fun getcover(): String {
        return details.imageUrlFront
    }
}

data class PokemonResponse (
    @Json(name = "results")
    val result: List<PokemonPi>
)

data class PokemonDetailedResponse(
    @Json(name = "sprites")
    val sprites: PokemonSprites
)
data class PokemonSprites( //sprites del Pokemon
    @Json(name = "front_default")
    val imageUrlFront: String,
    @Json(name = "back_default")
    val imageUrlBack: String ,
    @Json(name = "front_shiny")
    val imageUrlShinnyFront: String ,
    @Json(name = "back_shiny")
    val imageUrlShinnyBack: String
)


