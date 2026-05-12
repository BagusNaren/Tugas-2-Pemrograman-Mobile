package com.example.movieverse.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Spinner
import android.widget.TextView
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

    private lateinit var spinnerGenre: Spinner
    private lateinit var spinnerYear: Spinner
    private lateinit var spinnerRating: Spinner
    private lateinit var spinnerSort: Spinner

    private lateinit var checkFavorite: CheckBox

    // EMPTY STATE
    private lateinit var emptyStateLayout: LinearLayout
    private lateinit var txtEmpty: TextView

    private var movieList = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initViews()

        setupMovieRecyclerView()

        setupPopularRecyclerView()

        setupSearch()

        setupFilters()
    }

    private fun initViews() {

        recyclerMovie =
            findViewById(R.id.recyclerMovie)

        recyclerPopular =
            findViewById(R.id.recyclerPopular)

        searchView =
            findViewById(R.id.searchView)

        spinnerGenre =
            findViewById(R.id.spinnerGenre)

        spinnerYear =
            findViewById(R.id.spinnerYear)

        spinnerRating =
            findViewById(R.id.spinnerRating)

        spinnerSort =
            findViewById(R.id.spinnerSort)

        checkFavorite =
            findViewById(R.id.checkFavorite)

        emptyStateLayout =
            findViewById(R.id.emptyStateLayout)

        txtEmpty =
            findViewById(R.id.txtEmpty)
    }

    private fun setupMovieRecyclerView() {

        movieList =
            ArrayList(MovieData.movieList)

        movieAdapter =
            MovieAdapter(
                movieList
            ) {

                applyFilters()
            }

        recyclerMovie.layoutManager =
            LinearLayoutManager(this)

        recyclerMovie.adapter =
            movieAdapter

        recyclerMovie.isNestedScrollingEnabled =
            false

        recyclerMovie.setHasFixedSize(false)

        recyclerMovie.isFocusable =
            false

        recyclerMovie.isFocusableInTouchMode =
            false
    }

    private fun setupPopularRecyclerView() {

        popularMovieAdapter =
            PopularMovieAdapter(
                MovieData.popularMovieList
            )

        recyclerPopular.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )

        recyclerPopular.adapter =
            popularMovieAdapter

        recyclerPopular.isNestedScrollingEnabled =
            false

        recyclerPopular.setHasFixedSize(false)

        recyclerPopular.isFocusable =
            false

        recyclerPopular.isFocusableInTouchMode =
            false
    }

    private fun setupSearch() {

        searchView.isIconified = false

        searchView.clearFocus()

        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(
                    query: String?
                ): Boolean {

                    applyFilters()

                    return true
                }

                override fun onQueryTextChange(
                    newText: String?
                ): Boolean {

                    applyFilters()

                    return true
                }
            }
        )
    }

    private fun setupFilters() {

        val genres = listOf(
            "All Genre",
            "Action",
            "Drama",
            "Fantasy",
            "Sci-Fi",
            "Superhero"
        )

        val years = listOf(
            "All Year",
            "2009",
            "2010",
            "2014",
            "2016",
            "2019",
            "2021",
            "2022"
        )

        val ratings = listOf(
            "All Rating",
            "7+",
            "8+",
            "8.5+"
        )

        val sorts = listOf(
            "Sort By",
            "Rating Highest",
            "Rating Lowest",
            "Newest",
            "Oldest",
            "A-Z"
        )

        spinnerGenre.adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                genres
            )

        spinnerYear.adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                years
            )

        spinnerRating.adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                ratings
            )

        spinnerSort.adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                sorts
            )

        spinnerGenre.onItemSelectedListener =
            filterListener()

        spinnerYear.onItemSelectedListener =
            filterListener()

        spinnerRating.onItemSelectedListener =
            filterListener()

        spinnerSort.onItemSelectedListener =
            filterListener()

        checkFavorite.setOnCheckedChangeListener { _, _ ->

            applyFilters()
        }
    }

    private fun filterListener():
            AdapterView.OnItemSelectedListener {

        return object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                applyFilters()
            }

            override fun onNothingSelected(
                parent: AdapterView<*>?
            ) {}
        }
    }

    private fun applyFilters() {

        val filteredList =
            ArrayList<Movie>()

        val searchText =
            searchView.query.toString()
                .trim()
                .lowercase()

        val selectedGenre =
            spinnerGenre.selectedItem.toString()

        val selectedYear =
            spinnerYear.selectedItem.toString()

        val selectedRating =
            spinnerRating.selectedItem.toString()

        val selectedSort =
            spinnerSort.selectedItem.toString()

        val favoriteOnly =
            checkFavorite.isChecked

        for (movie in movieList) {

            var matches = true

            if (
                searchText.isNotEmpty() &&
                !movie.title.lowercase()
                    .contains(searchText)
            ) {

                matches = false
            }

            if (
                selectedGenre != "All Genre" &&
                movie.genre != selectedGenre
            ) {

                matches = false
            }

            if (
                selectedYear != "All Year" &&
                movie.year != selectedYear
            ) {

                matches = false
            }

            when (selectedRating) {

                "7+" -> {

                    if (movie.rating < 7.0) {

                        matches = false
                    }
                }

                "8+" -> {

                    if (movie.rating < 8.0) {

                        matches = false
                    }
                }

                "8.5+" -> {

                    if (movie.rating < 8.5) {

                        matches = false
                    }
                }
            }

            if (
                favoriteOnly &&
                !movie.isFavorite
            ) {

                matches = false
            }

            if (matches) {

                filteredList.add(movie)
            }
        }

        when (selectedSort) {

            "Rating Highest" -> {

                filteredList.sortByDescending {
                    it.rating
                }
            }

            "Rating Lowest" ->  {

                filteredList.sortBy {
                    it.rating
                }
            }

            "Newest" -> {

                filteredList.sortByDescending {
                    it.year.toInt()
                }
            }

            "Oldest" -> {

                filteredList.sortBy {
                    it.year.toInt()
                }
            }

            "A-Z" -> {

                filteredList.sortBy {
                    it.title
                }
            }
        }

        if (filteredList.isEmpty()) {

            emptyStateLayout.visibility =
                View.VISIBLE

            recyclerMovie.visibility =
                View.GONE

            txtEmpty.text =
                "🎬 No movies found"

        } else {

            emptyStateLayout.visibility =
                View.GONE

            recyclerMovie.visibility =
                View.VISIBLE
        }

        movieAdapter.filterList(filteredList)
    }
}