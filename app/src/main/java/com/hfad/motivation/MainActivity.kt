package com.hfad.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.hfad.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

  //  private late init var navController1 : NavController
    lateinit var viewModel : AddQuoteViewModel
    lateinit var viewModel2: FavoritesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)

        val navController = navHostFragment?.findNavController()

        binding.bottomNav.setupWithNavController(navController!!)

        setUpViewModel()

        setUpViewModel2()



        /*navController1.addOnDestinationChangedListener(object  : NavController.OnDestinationChangedListener {
            override fun onDestinationChanged (
                navController: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {
                if (destination.id == R.id.addQuoteFragment) {
                    hideBottomNav()
                } else {
                    showBottomNav()
                }
            }
        })*/
    }

    private fun setUpViewModel() {
        val repository = QuoteRepository(QuoteDataBase(this))
        val viewModelFactory = AddQuoteViewModelFactory(application, repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[AddQuoteViewModel::class.java]
    }
    private fun setUpViewModel2() {
        val repository = FavoritesRepository(FavoritesDatabase.getInstance(this))
        val viewModelFactory = FavoritesViewModelFactory(application, repository)
        viewModel2 = ViewModelProvider(this, viewModelFactory)[FavoritesViewModel::class.java]
    }

    /*fun hideBottomNav() {
        binding.bottomNav.visibility = View.GONE
    }

     fun showBottomNav() {
        binding.bottomNav.visibility = View.VISIBLE
    }*/

    public fun hideBottomNav() {
    binding.bottomNav.visibility = View.GONE
    }

    public fun showBottomNav() {
        binding.bottomNav.visibility = View.VISIBLE
    }



}