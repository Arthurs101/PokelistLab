package gt.uvg.pokelist.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import kotlin.math.log


class PokemonListAdapter(private var pokemonList: List<PokemonPi>  ) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>() {

    inner class PokemonListHolder(val binding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(binding.root){ //subclase de pokemon para el binding
        var name = binding.pokemonName ;
        var foto = binding.pokemonPhoto;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder { //crear los holders
        val binding = ItemPokemonViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) { //asignarle al elemento sus propiedades
        val item = pokemonList.get(position)
        holder.name.text = item.name;
        Picasso.get().load(item.getcover()).resize(80,80)
            .placeholder(R.drawable.whoisthatpokemon).resize(80,80).error(R.drawable.whoisthatpokemon)
            .resize(80,80).noFade()
            .into(holder.foto)
        holder.itemView.setOnClickListener {
            val action =
                MainFragmentDirections.actionMainFragmentToDetailFragment(item.details.imageUrlShinnyFront,item.details.imageUrlShinnyBack,item.details.imageUrlFront,item.details.imageUrlBack)
            holder.binding.root.findNavController()
                .navigate(action)  //usar la vista fuente del holder para nacegar hacia el fragmento de detalles
        }
    }

    override fun getItemCount(): Int { //regresar el tamaño de la lista para  el linear layout
        // TODO
        return pokemonList.size
    }



}