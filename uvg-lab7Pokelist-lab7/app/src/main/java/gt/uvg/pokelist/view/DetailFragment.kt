package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.FragmentDetailBinding
import gt.uvg.pokelist.model.Pokemon

class DetailFragment : Fragment() {
    val arg: DetailFragmentArgs by navArgs()
    private lateinit var recyclerView: RecyclerView //recycler view
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment (para mostrarla)
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { //colocar todas las imágenes en las imageview
        val Pokemoninfo = Pokemon (arg.pokemonId, "unknown") //obtener el pokemon pasado en el argumento
        Picasso.get().load(Pokemoninfo.imageUrlFront).into(binding.imageView2)
        Picasso.get().load(Pokemoninfo.imageUrlBack).into(binding.imageView3)
        Picasso.get().load(Pokemoninfo.imageUrlShinnyBack).into(binding.imageView5)
        Picasso.get().load(Pokemoninfo.imageUrlShinnyFront).into(binding.imageView4)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null //cuando no se está viendo el fragmento, quitar el binding
    }

}