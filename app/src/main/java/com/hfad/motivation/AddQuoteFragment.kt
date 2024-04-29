package com.hfad.motivation

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.hfad.motivation.databinding.FragmentAddQuoteBinding

class AddQuoteFragment : Fragment() {
    private var _binding: FragmentAddQuoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var userList: ArrayList<Quote>
    private lateinit var userAdapter: UserAdapter
    private lateinit var viewModel: AddQuoteViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddQuoteBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.backButton.setOnClickListener{
            view.findNavController()
                .navigate(R.id.action_addQuoteFragment_to_quotesFragment)
        }

        viewModel = (activity as MainActivity).viewModel









        // set List
        userList = ArrayList()
        //set Adapter
         userAdapter = UserAdapter(requireContext(), userList)
        binding.recyclerAdd.adapter = userAdapter
        // set Dialog
        binding.addingBtn.setOnClickListener { addInfo()

        }





        // Inflate the layout for this fragment
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).hideBottomNav()
    }

    override fun onPause() {
        super.onPause()
        (requireActivity() as MainActivity).showBottomNav()
    }

    private fun addInfo() {
        val inflater = LayoutInflater.from(requireContext())
        val v  = inflater.inflate(R.layout.add_dialog, null)
        // set view
        val userNo = v.findViewById<EditText>(R.id.user)
        val userName = v.findViewById<EditText>(R.id.userInput)

        val addDialog = AlertDialog.Builder(requireContext())
        addDialog.setView(v)
        addDialog.setPositiveButton("Save"){
                dialog,_ ->
            val number = userNo.text.toString().trim()
            val names = userName.text.toString().trim()
            if (number.isNotEmpty() && !number.startsWith(" ")){
                val quote = Quote(0,number, names)
                viewModel.addQuote(quote)

                binding.recyclerAdd.visibility = View.GONE
                binding.recyclerAdd.visibility = View.VISIBLE


            } else {
                Toast.makeText(requireContext(), "Field cannot be empty",Toast.LENGTH_SHORT).show()

                binding.recyclerAdd.visibility = View.VISIBLE
                binding.recyclerAdd.visibility = View.GONE

            }




            userList.add(Quote(0,"Author: $number", "Quote:$names "))
            userAdapter.notifyDataSetChanged()
            Toast.makeText(requireContext(),"Quotes add Successful ",Toast.LENGTH_SHORT).show()

            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
            dialog,_ ->
            dialog.dismiss()
            Toast.makeText(requireContext(),"Cancel",Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()
    }




}
