package com.caren.dogpictures.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.caren.dogpictures.R
import com.caren.dogpictures.databinding.FragmentSelectSearchBinding

class SearchSelectFragment : Fragment() {

    private lateinit var binding: FragmentSelectSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectSearchBinding.inflate(inflater, container, false)
        return binding.root //inflater.inflate(R.layout.todo_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.breedSearch.setOnClickListener { findNavController().navigate(R.id.action_searchSelectFragment_to_breedSearchFragment) }
        binding.randomSearch.setOnClickListener { findNavController().navigate(R.id.action_searchSelectFragment_to_randomDogFragment) }
    }
}