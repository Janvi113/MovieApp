package com.example.movieapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.model.Movie
import com.example.movieapp.network.MovieService
import javax.inject.Inject

class Repository @Inject constructor(private val movieService: MovieService) {

    val moviereport=MutableLiveData<Movie>()

    val movielivedata:LiveData<Movie>
        get() {
          return moviereport
        }

    suspend fun getallmovie(){
        val data=movieService.getallmovies()
        if (data?.body()!=null){
           moviereport.postValue(data.body())
        }
    }
}