package gt.uvg.pokelist.repository
import gt.uvg.pokelist.view.PokemonDetailedResponse
import gt.uvg.pokelist.view.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//interfaz con el servicio de conexción a la base de datos de los pokemones
interface PokemonService {
    //llamar a los primeros 100 pokemones
    @GET("pokemon?limit=100")
    fun getFirst100Pokemon(): Call<PokemonResponse>
    //llamar a los datos de un pokemon
    @GET("{ref}")
    fun getPokeData(@Path("ref") url: String): Call<PokemonDetailedResponse>
}