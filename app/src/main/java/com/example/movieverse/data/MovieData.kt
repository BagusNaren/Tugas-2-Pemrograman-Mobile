package com.example.movieverse.data

import com.example.movieverse.R
import com.example.movieverse.model.Movie

object MovieData {

    val movieList = listOf(

        Movie(
            id = 1,
            title = "Interstellar",
            genre = "Sci-Fi",
            rating = 8.9,
            year = "2014",
            duration = "2h 49m",
            imageResId = R.drawable.interstellar,
            description =
                "A team of explorers travels through a wormhole in space to save humanity.",
            cast =
                "Matthew McConaughey, Anne Hathaway, Jessica Chastain",
            director =
                "Christopher Nolan"
        ),

        Movie(
            id = 2,
            title = "Inception",
            genre = "Action",
            rating = 8.8,
            year = "2010",
            duration = "2h 28m",
            imageResId = R.drawable.inception,
            description =
                "A skilled thief enters people's dreams to steal valuable secrets.",
            cast =
                "Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page",
            director =
                "Christopher Nolan"
        ),

        Movie(
            id = 3,
            title = "Avatar",
            genre = "Fantasy",
            rating = 7.9,
            year = "2009",
            duration = "2h 42m",
            imageResId = R.drawable.avatar,
            description =
                "Humans explore the alien world of Pandora and face conflicts with the Na'vi.",
            cast =
                "Sam Worthington, Zoe Saldana, Sigourney Weaver",
            director =
                "James Cameron"
        ),

        Movie(
            id = 4,
            title = "The Batman",
            genre = "Action",
            rating = 8.1,
            year = "2022",
            duration = "2h 56m",
            imageResId = R.drawable.batman,
            description =
                "Batman investigates corruption and a mysterious serial killer in Gotham City.",
            cast =
                "Robert Pattinson, Zoë Kravitz, Paul Dano",
            director =
                "Matt Reeves"
        ),

        Movie(
            id = 5,
            title = "Joker",
            genre = "Drama",
            rating = 8.4,
            year = "2019",
            duration = "2h 2m",
            imageResId = R.drawable.joker,
            description =
                "A failed comedian slowly transforms into Gotham's infamous villain.",
            cast =
                "Joaquin Phoenix, Robert De Niro, Zazie Beetz",
            director =
                "Todd Phillips"
        ),

        Movie(
            id = 6,
            title = "Avengers Endgame",
            genre = "Superhero",
            rating = 8.4,
            year = "2019",
            duration = "3h 1m",
            imageResId = R.drawable.endgame,
            description =
                "The Avengers unite once more to reverse Thanos' actions and save the universe.",
            cast =
                "Robert Downey Jr., Chris Evans, Scarlett Johansson",
            director =
                "Anthony Russo & Joe Russo"
        ),

        Movie(
            id = 7,
            title = "Doctor Strange",
            genre = "Fantasy",
            rating = 7.5,
            year = "2016",
            duration = "1h 55m",
            imageResId = R.drawable.doctor_strange,
            description =
                "A surgeon learns mystical arts after a tragic accident changes his life.",
            cast =
                "Benedict Cumberbatch, Chiwetel Ejiofor, Rachel McAdams",
            director =
                "Scott Derrickson"
        ),

        Movie(
            id = 8,
            title = "Spider-Man: Homecoming",
            genre = "Superhero",
            rating = 8.2,
            year = "2021",
            duration = "2h 28m",
            imageResId = R.drawable.spiderman,
            description =
                "Spider-Man faces multiverse chaos after his identity is revealed.",
            cast =
                "Tom Holland, Zendaya, Benedict Cumberbatch",
            director =
                "Jon Watts"
        )
    )

    val popularMovieList = listOf(

        Movie(
            id = 1,
            title = "Interstellar",
            genre = "Sci-Fi",
            rating = 8.9,
            year = "2014",
            duration = "2h 49m",
            imageResId = R.drawable.interstellar,
            description =
                "A team of explorers travels through a wormhole in space.",
            cast =
                "Matthew McConaughey, Anne Hathaway, Jessica Chastain",
            director =
                "Christopher Nolan"
        ),

        Movie(
            id = 2,
            title = "Inception",
            genre = "Action",
            rating = 8.8,
            year = "2010",
            duration = "2h 28m",
            imageResId = R.drawable.inception,
            description =
                "A thief steals secrets through dream-sharing technology.",
            cast =
                "Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page",
            director =
                "Christopher Nolan"
        ),

        Movie(
            id = 3,
            title = "The Batman",
            genre = "Action",
            rating = 8.1,
            year = "2022",
            duration = "2h 56m",
            imageResId = R.drawable.batman,
            description =
                "Batman investigates a serial killer targeting Gotham elites.",
            cast =
                "Robert Pattinson, Zoë Kravitz, Paul Dano",
            director =
                "Matt Reeves"
        )
    )
}