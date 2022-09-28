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
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.FragmentDetailBinding


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

        Picasso.get().load(arg.front).error(R.drawable.whoisthatpokemon).into(binding.imageView2)
        Picasso.get().load(arg.back).error(R.drawable.whoisthatpokemon).into(binding.imageView3)
        Picasso.get().load(arg.backShiny).error(R.drawable.whoisthatpokemon).into(binding.imageView5)
        Picasso.get().load(arg.frontShiny).error(R.drawable.whoisthatpokemon).into(binding.imageView4)
        binding.progressBar2.visibility = View.GONE
        binding.DertailLayout.visibility = View.VISIBLE

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null //cuando no se está viendo el fragmento, quitar el binding
    }

}