package com.caren.dogpictures.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.caren.dogpictures.MainViewModel
import com.caren.dogpictures.databinding.FragmentBreedSearchBinding
import java.lang.Exception


public lateinit var breedBinding: FragmentBreedSearchBinding

lateinit var breed: String

class BreedSearchFragment: Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        breedBinding = FragmentBreedSearchBinding.inflate(inflater, container, false)
        return breedBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBreed()
        breedBinding.dogBreedButton.setOnClickListener {  setBreed() }
        breedBinding.breedSearchButton.setOnClickListener { viewModel.getNewDogBreed() }
        viewModel.currentlyDisplayedDog.observe(viewLifecycleOwner,
            { breedBinding.dogBreedImage.load(it?.url)})
    }

    public fun setBreed(): String {
        if (breedBinding.dogBreedEditText.text.toString() != "") {
            breed = "https://dog.ceo/api/breed/${breedBinding.dogBreedEditText.text.toString()}/images/"
            Log.i("setBreed", breed)
            try {
                //viewModel.setNewDogBreed(breed)
            } catch (e: Exception) {
                Log.i("setBreed exception", breed)
                breed = "https://dog.ceo/api/breeds/image/"
                //viewModel.setNewDogBreed(breed)
            }
        }
        else {
            breed = "https://dog.ceo/api/breeds/image/"
            Log.i("setBreed else clause", breed)
            //setNewDogBreed(breed)
        }
        return breed
    }

    /*public fun setNewDogBreed(nextBreed: String): String {
        breed = nextBreed
        Log.i("test_url:", " $breed")
        return breed
    }*/
}