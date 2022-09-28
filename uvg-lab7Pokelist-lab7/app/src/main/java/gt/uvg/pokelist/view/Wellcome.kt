package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import gt.uvg.pokelist.databinding.FragmentWellcomeBinding

class Wellcome : Fragment() {
    private var _binding: FragmentWellcomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(  //inflar el fragmento
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWellcomeBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener{
            var amount = binding.PokemonNumber.text.toString()
            if (amount == ""){
                amount = "0"
            }
            val action =  WellcomeDirections.actionWellcomeToMainFragment(amount)
            binding.root.findNavController().navigate(action)
        }
    }
}