package com.hfad.motivation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hfad.motivation.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private var favoriteLists: List<QuotesDataClass> = mutableListOf()
    private lateinit var adapter: FavoritesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val view = binding.root




        adapter = FavoritesAdapter(requireContext(),favoriteLists)
        binding.recyclerFavorite.adapter = adapter










        // Inflate the layout for this fragment
        return view
    }




    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }
}
