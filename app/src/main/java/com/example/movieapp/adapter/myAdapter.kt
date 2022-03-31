package com.example.movieapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.activity.MovieDetails
import com.example.movieapp.model.MovieItem

class myAdapter(private val context: Context,val movielist:List<MovieItem>
):RecyclerView.Adapter<myAdapter.myvieholder>() {
    class myvieholder(itemView: View) :RecyclerView.ViewHolder(itemView){
     val movieimage=itemView.findViewById<ImageView>(R.id.movieimage)
        val movietitle=itemView.findViewById<TextView>(R.id.movietitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myvieholder {
       val view=LayoutInflater.from(context).inflate(R.layout.moviesitems,parent,false)
        return myvieholder(view)
    }

    override fun onBindViewHolder(holder: myvieholder, position: Int) {
        val data=movielist[position]
        val imageurl="https://image.tmdb.org/t/p/w500"+data.backdropPath
        holder.movietitle.text=data.originalTitle
        Glide.with(context)
            .load(imageurl)
            .into(holder.movieimage)
        holder.itemView.setOnClickListener {
            val intent= Intent(context,MovieDetails::class.java)
            val imageurls="https://image.tmdb.org/t/p/w500"+data.posterPath
            intent.putExtra("imagess",imageurls)
            intent.putExtra("title", data.title)
            intent.putExtra("release",data.releaseDate)
            intent.putExtra("overview",data.overview)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movielist.size
    }
}
