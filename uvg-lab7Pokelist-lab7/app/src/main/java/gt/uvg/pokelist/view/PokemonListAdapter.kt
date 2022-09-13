package gt.uvg.pokelist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon

class PokemonListAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>() {

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
        Picasso.get().load(item.imageUrlFront).into(holder.foto)
        holder.itemView.setOnClickListener {
            val action =
                MainFragmentDirections.actionMainFragmentToDetailFragment(pokemonList.get(position).id)
            holder.binding.root.findNavController()
                .navigate(action)  //usar la vista fuente del holder para nacegar hacia el fragmento de detalles
        }
    }

    override fun getItemCount(): Int { //regresar el tamaño de la lista para  el linear layout
        // TODO
        return pokemonList.size
    }


}