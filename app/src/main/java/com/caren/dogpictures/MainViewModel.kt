package com.caren.dogpictures

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caren.dogpictures.fragments.breed
import com.caren.dogpictures.network.Dog
import com.caren.dogpictures.network.DogQuotesApi
import kotlinx.coroutines.launch



class MainViewModel() : ViewModel() {

   // lateinit var newBreed: String
    private val _currentlyDisplayedDog = MutableLiveData<Dog>()
    val currentlyDisplayedDog: LiveData<Dog> = _currentlyDisplayedDog

      init {
        Log.i("init", breed)
        getNewDog()
    }

    fun getNewDog() {
        viewModelScope.launch {
            // The response from https://zenquotes.io/api/random is a list of 1 quote, so we
            // are getting the first item in the list from the response.
            Log.i("getNewDog", breed)
            //getNewDogBreed(breed)
            _currentlyDisplayedDog.value = DogQuotesApi.retrofitService.getRandomDog()
             /* catch (e: retrofit2.HttpException) {
                BASE_URL = "https://dog.ceo/api/breeds/image/"
                Log.i("test_breed", "$breed")
                Log.i("test_url2:", " $BASE_URL")
                _currentlyDisplayedDog.value = DogQuotesApi.retrofitService.getRandomDog()
            } */
        }

    }



    public fun getNewDogBreed() {
        viewModelScope.launch {
            Log.i("getNewDogBreed", breed)
            _currentlyDisplayedDog.value = DogQuotesApi.breedRetrofit.getRandomDog()
        }
    }
}

