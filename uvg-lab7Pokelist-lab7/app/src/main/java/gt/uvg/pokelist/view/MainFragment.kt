package gt.uvg.pokelist.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.databinding.FragmentMainBinding
import gt.uvg.pokelist.repository.PokemonApi
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

//fragmento principal donde se muestra la lista de los pokemons
class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var PokemosTempRepo: List<PokemonPi> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(  //inflar el fragmento
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { //crear el linear el layout
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.visibility = View.VISIBLE
        val pokeApi = PokemonApi.service.getFirst100Pokemon()
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        pokeApi.enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                if(response.isSuccessful){
                    Log.d("Result", ""+response.body())
                    val pokemons = response.body()?.result
                    pokemons?.let {recyclerView.adapter = PokemonListAdapter(pokemons)  }
                }
                //quitar progress bar y mostrar el recyclerview
                
                binding.progressBar.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
            }
            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {

                Log.d("FAILEDTOLOAD", ""+t.message)
            }
        })




    }

    override fun onDestroyView() { //quitar el binding cuando no se está usando el fragmento
        super.onDestroyView()
        _binding = null
    }
}