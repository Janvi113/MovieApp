package com.example.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.model.Movie
import com.example.movieapp.repository.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(private val repository: Repository):ViewModel() {

   init {
       viewModelScope.launch{
           repository.getallmovie()
       }
   }

    val liveData:LiveData<Movie>
        get() {
           return repository.movielivedata
        }
}