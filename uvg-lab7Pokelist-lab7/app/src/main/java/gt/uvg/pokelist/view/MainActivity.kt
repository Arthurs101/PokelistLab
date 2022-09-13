package gt.uvg.pokelist.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    // Keeps track of which LayoutManager is in use for the [RecyclerView]

    private lateinit var navController: NavController //controlador de navegación
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater) //crear el binder para poder expandir y pasar argumentos
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController) //asegurar que los botones aparezcan y que su acción se propague al controlador de navegación
    }
    override fun onSupportNavigateUp(): Boolean { //permitir uso del boton de regresar
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}