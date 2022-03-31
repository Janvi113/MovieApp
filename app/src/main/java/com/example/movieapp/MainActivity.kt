package com.example.movieapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.adapter.myAdapter
import com.example.movieapp.di.AppModule
import com.example.movieapp.network.BASE_URL
import com.example.movieapp.network.MovieService
import com.example.movieapp.repository.Repository
import com.example.movieapp.viewmodel.MainViewModel
import com.example.movieapp.viewmodel.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var myAdapter: myAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service=AppModule.provideInstance(BASE_URL).create(MovieService::class.java)
        val repository=Repository(service)
        mainViewModel=ViewModelProvider(this,ViewModelFactory(repository))[MainViewModel::class.java]
        initmv()
    }

    private fun initmv() {
        mainViewModel.liveData.observe(this, Observer {
            if (it!=null){
                Log.d("JANVI",it.results.toString())
                myAdapter= myAdapter(this,it.results)
                recyclerview.apply {
                    adapter=myAdapter
                    layoutManager=LinearLayoutManager(this@MainActivity)
                }
            }
        })
    }



}