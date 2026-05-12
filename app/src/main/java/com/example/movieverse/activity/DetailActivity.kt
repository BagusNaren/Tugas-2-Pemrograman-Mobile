package com.example.movieverse.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.movieverse.R

class DetailActivity : AppCompatActivity() {

    private lateinit var detailImage: ImageView

    private lateinit var detailTitle: TextView
    private lateinit var detailGenre: TextView
    private lateinit var detailRating: TextView
    private lateinit var detailYear: TextView
    private lateinit var detailDuration: TextView
    private lateinit var detailDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        initViews()

        getMovieData()
    }

    private fun initViews() {

        detailImage =
            findViewById(R.id.detailImage)

        detailTitle =
            findViewById(R.id.detailTitle)

        detailGenre =
            findViewById(R.id.detailGenre)

        detailRating =
            findViewById(R.id.detailRating)

        detailYear =
            findViewById(R.id.detailYear)

        detailDuration =
            findViewById(R.id.detailDuration)

        detailDescription =
            findViewById(R.id.detailDescription)
    }

    private fun getMovieData() {

        val title =
            intent.getStringExtra("title")

        val genre =
            intent.getStringExtra("genre")

        val rating =
            intent.getDoubleExtra("rating", 0.0)

        val year =
            intent.getStringExtra("year")

        val duration =
            intent.getStringExtra("duration")

        val image =
            intent.getIntExtra("image", 0)

        val description =
            intent.getStringExtra("description")

        detailImage.setImageResource(image)

        detailTitle.text = title

        detailGenre.text = genre

        detailRating.text = "⭐ $rating"

        detailYear.text = year

        detailDuration.text = duration

        detailDescription.text = description
    }
}