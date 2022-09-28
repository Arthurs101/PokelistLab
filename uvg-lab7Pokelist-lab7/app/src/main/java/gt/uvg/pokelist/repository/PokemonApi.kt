package gt.uvg.pokelist.repository

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


//clase que establece concecxión a la base de datos empleando retrofit
object PokemonApi {
    //conversor moshi
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val retrofit = Retrofit.Builder()  //objeto de tipo retrofit que se conecta a la base de datos
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    val service: PokemonService by lazy { retrofit.create (PokemonService::class.java)  } //crear el servicio (el cual maneja las operaciones de requests a la base datos)
}