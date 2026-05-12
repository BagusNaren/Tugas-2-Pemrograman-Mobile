package com.example.movieverse.ui

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieverse.R
import com.example.movieverse.adapter.MovieAdapter
import com.example.movieverse.adapter.PopularMovieAdapter
import com.example.movieverse.data.MovieData
import com.example.movieverse.model.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerMovie: RecyclerView
    private lateinit var recyclerPopular: RecyclerView

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var popularMovieAdapter: PopularMovieAdapter

    private lateinit var searchView: SearchView

    private var movieList = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initViews()

        setupMovieRecyclerView()

        setupPopularRecyclerView()

        setupSearch()
    }

    private fun initViews() {

        recyclerMovie =
            findViewById(R.id.recyclerMovie)

        recyclerPopular =
            findViewById(R.id.recyclerPopular)

        searchView =
            findViewById(R.id.searchView)
    }

    private fun setupMovieRecyclerView() {

        movieList = ArrayList(MovieData.movieList)

        movieAdapter = MovieAdapter(movieList)

        recyclerMovie.layoutManager =
            LinearLayoutManager(this)

        recyclerMovie.adapter = movieAdapter
    }

    private fun setupPopularRecyclerView() {

        popularMovieAdapter =
            PopularMovieAdapter(MovieData.popularMovieList)

        recyclerPopular.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )

        recyclerPopular.adapter =
            popularMovieAdapter
    }

    private fun setupSearch() {

        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(
                    query: String?
                ): Boolean {
                    return false
                }

                override fun onQueryTextChange(
                    newText: String?
                ): Boolean {

                    filterMovies(newText)

                    return true
                }
            }
        )
    }

    private fun filterMovies(query: String?) {

        val filteredList = ArrayList<Movie>()

        if (query.isNullOrEmpty()) {

            filteredList.addAll(movieList)

        } else {

            val searchText =
                query.lowercase()

            for (movie in movieList) {

                if (
                    movie.title.lowercase()
                        .contains(searchText)
                ) {

                    filteredList.add(movie)
                }
            }
        }

        movieAdapter.filterList(filteredList)
    }
}