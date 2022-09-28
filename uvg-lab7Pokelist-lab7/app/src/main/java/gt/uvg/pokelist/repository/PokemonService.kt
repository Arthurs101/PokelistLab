package gt.uvg.pokelist.repository
import gt.uvg.pokelist.view.PokemonDetailedResponse
import gt.uvg.pokelist.view.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//interfaz con el servicio de conexción a la base de datos de los pokemones
interface PokemonService {
    @GET("pokemon")
    fun getPokemons(@Query("limit") url: String): Call<PokemonResponse>
    //llamar a los datos de un pokemon
    @GET("{ref}")
    fun getPokeData(@Path("ref") url: String): Call<PokemonDetailedResponse>
}