package com.example.movieverse.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieverse.R
import com.example.movieverse.model.Movie
import com.example.movieverse.ui.DetailActivity

class PopularMovieAdapter(
    private val popularMovieList: List<Movie>
) : RecyclerView.Adapter<PopularMovieAdapter.PopularMovieViewHolder>() {

    class PopularMovieViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val imgMovie: ImageView =
            itemView.findViewById(R.id.imgPopularMovie)

        val txtTitle: TextView =
            itemView.findViewById(R.id.txtPopularTitle)

        val txtRating: TextView =
            itemView.findViewById(R.id.txtPopularRating)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularMovieViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_popular_movie,
                parent,
                false
            )

        return PopularMovieViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PopularMovieViewHolder,
        position: Int
    ) {

        val movie = popularMovieList[position]

        holder.imgMovie.setImageResource(movie.imageResId)

        holder.txtTitle.text = movie.title

        holder.txtRating.text = "⭐ ${movie.rating}"

        holder.itemView.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                DetailActivity::class.java
            )

            intent.putExtra("title", movie.title)
            intent.putExtra("genre", movie.genre)
            intent.putExtra("rating", movie.rating)
            intent.putExtra("year", movie.year)
            intent.putExtra("duration", movie.duration)
            intent.putExtra("image", movie.imageResId)
            intent.putExtra("description", movie.description)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return popularMovieList.size
    }
}