package com.csalex.recipesapp.ui.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.csalex.recipesapp.R
import com.csalex.recipesapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding
    private val TAG: String? = ProfileFragment::class.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addFloatingActionButton.setOnClickListener {
            Log.d(TAG, "Clicked")
            findNavController().navigate(R.id.action_profileFragment_to_newRecipeFragment)
        }

    }


}