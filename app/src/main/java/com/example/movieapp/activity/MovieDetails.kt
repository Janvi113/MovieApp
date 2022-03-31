package com.example.movieapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movieapp.R
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val imageo=intent.getStringExtra("imagess")
        val movietitle=intent.getStringExtra("title")
        val movieoverview=intent.getStringExtra("overview")
        val release=intent.getStringExtra("release")
       moviename.setText(movietitle)
        overview.setText(movieoverview)
        releasedatte.setText(release)
        Glide.with(this)
            .load(imageo)
            .into(imageposter)

    }
}


