package com.caren.dogpictures.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.caren.dogpictures.MainViewModel
import com.caren.dogpictures.databinding.FragmentRandomSearchBinding

private lateinit var binding: FragmentRandomSearchBinding

class RandomDogFragment: Fragment() {


    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dogButton.setOnClickListener {  viewModel.getNewDog() }
        viewModel.currentlyDisplayedDog.observe(viewLifecycleOwner,
            { binding.dogImage.load(it?.url)})
    }


}