package com.example.movieapp.network

import com.example.movieapp.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL="https://api.themoviedb.org/"
const val API_KEY="158d246200c8fe8baf6e9a2c357b7433"
interface MovieService {

    @GET("3/movie/popular?api_key=$API_KEY")
    suspend fun getallmovies(
    ):Response<Movie>
}