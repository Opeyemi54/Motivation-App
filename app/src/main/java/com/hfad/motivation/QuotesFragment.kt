package com.hfad.motivation

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hfad.motivation.databinding.FragmentQuotesBinding

class QuotesFragment : Fragment() {
    private var _binding: FragmentQuotesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: QuotesAdapter
    private lateinit var viewModel:FavoritesViewModel

    /* quote position in quote lists
    increment when user click on next button
    decrement when user click on prev button*/
    //private var motivationNumber : Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentQuotesBinding.inflate(inflater, container, false)
        val view = binding.root

        /*val application = requireNotNull(this.activity).application
        val dao = FavoritesDatabase.getInstance(application).dao()
        val viewModelFactory = FavoritesViewModelFactory()*/
        viewModel = (activity as MainActivity).viewModel2
        




        val quotesLists: MutableList<QuotesDataClass> = mutableListOf()

         quotesLists.addAll(MotivationQuotes.getLifeQuotes())
        quotesLists.addAll(MotivationQuotes.getLoveQuotes())
       quotesLists.addAll(MotivationQuotes.getSuccessQuotes())
       quotesLists.addAll(MotivationQuotes.getMotivationQuotes())
        quotesLists.addAll(MotivationQuotes.getEnglishQuotes())




        adapter = QuotesAdapter(requireContext(), quotesLists, viewModel)
        binding.quoteRecycler.adapter = adapter




        //setQuotesToTextView()

        /*binding.heartCheckbox.setOnCheckedChangeListener{
                _, isChecked ->
            // update the liked status of the current quote
            quotesLists[motivationNumber].isFavorite = isChecked
            if (isChecked) {
                // checkbox is checked, display message saying quote added to favorites
                showToast("Quote added to favorites!")
            } else{
                // checkbox is unchecked, display message saying quote removed from favorites
                showToast("Quotes removed from favourites!")
            }
        }*/


        // set prev button to get previous quote
        /*binding.prevButton.setOnClickListener{
            // decrement motivationNumber to get previous quote from Motivation
            motivationNumber--

            // check if motivationNumber is smaller than 0 then get last quote from motivation
            if (motivationNumber < 0){
                motivationNumber = quotesLists.size - 1
            }

            setQuotesToTextView()
        }

        // set next button to get next quote
        binding.nextButton.setOnClickListener{
            // increment motivationNumber to get next quote from quotesLists
            motivationNumber++
            // check if more quotes are available from Motivation
            if (motivationNumber >= quotesLists.size){
                motivationNumber = 0
            }
            setQuotesToTextView()
        }*/

        binding.addQuote.setOnClickListener{
            view.findNavController()
                .navigate(R.id.action_quotesFragment_to_addQuoteFragment)
        }







        // Inflate the layout for this fragment
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




    /*private fun setQuotesToTextView() {
        // get quotes from list from current position
        binding.quoteContent.text = quotesLists[motivationNumber].getQuote()

        // get quotes from list from current position
        binding.writerName.text = quotesLists[motivationNumber].getWriter()
    }*/

    /*private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }*/




}
