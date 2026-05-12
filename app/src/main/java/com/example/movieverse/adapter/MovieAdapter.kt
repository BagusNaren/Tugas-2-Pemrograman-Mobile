package com.example.movieverse.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieverse.R
import com.example.movieverse.model.Movie
import com.example.movieverse.ui.DetailActivity

class MovieAdapter(

    private var movieList: MutableList<Movie>,

    private val onFavoriteChanged: (() -> Unit)? = null

) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val cardMovie: CardView =
            itemView.findViewById(R.id.cardMovie)

        val imgMovie: ImageView =
            itemView.findViewById(R.id.imgMovie)

        val txtTitle: TextView =
            itemView.findViewById(R.id.txtTitle)

        val txtGenre: TextView =
            itemView.findViewById(R.id.txtGenre)

        val txtRating: TextView =
            itemView.findViewById(R.id.txtRating)

        val txtYear: TextView =
            itemView.findViewById(R.id.txtYear)

        val btnFavorite: ImageButton =
            itemView.findViewById(R.id.btnFavorite)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_movie,
                parent,
                false
            )

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    ) {

        val movie = movieList[position]

        holder.imgMovie.setImageResource(
            movie.imageResId
        )

        holder.txtTitle.text =
            movie.title

        holder.txtGenre.text =
            movie.genre

        holder.txtRating.text =
            "⭐ ${movie.rating}"

        holder.txtYear.text =
            movie.year

        updateFavoriteIcon(holder, movie)

        holder.btnFavorite.setOnClickListener {

            movie.isFavorite =
                !movie.isFavorite

            updateFavoriteIcon(holder, movie)

            onFavoriteChanged?.invoke()
        }

        holder.itemView.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                DetailActivity::class.java
            )

            intent.putExtra(
                "title",
                movie.title
            )

            intent.putExtra(
                "genre",
                movie.genre
            )

            intent.putExtra(
                "rating",
                movie.rating
            )

            intent.putExtra(
                "year",
                movie.year
            )

            intent.putExtra(
                "duration",
                movie.duration
            )

            intent.putExtra(
                "image",
                movie.imageResId
            )

            intent.putExtra(
                "description",
                movie.description
            )

            intent.putExtra(
                "cast",
                movie.cast
            )
            intent.putExtra(
                "director",
                movie.director
            )

            holder.itemView.context
                .startActivity(intent)
        }
    }

    override fun getItemCount(): Int {

        return movieList.size
    }

    fun filterList(
        filteredList: List<Movie>
    ) {

        movieList =
            filteredList.toMutableList()

        notifyDataSetChanged()
    }

    private fun updateFavoriteIcon(
        holder: MovieViewHolder,
        movie: Movie
    ) {

        if (movie.isFavorite) {

            holder.btnFavorite
                .setImageResource(
                    R.drawable.ic_favorite
                )

        } else {

            holder.btnFavorite
                .setImageResource(
                    R.drawable.ic_favorite_border
                )
        }
    }
}