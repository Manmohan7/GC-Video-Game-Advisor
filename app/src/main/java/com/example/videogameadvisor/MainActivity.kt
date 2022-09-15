package com.example.videogameadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findGames = findViewById<Button>(R.id.find_games)

        findGames.setOnClickListener {
            val gameGenres = findViewById<Spinner>(R.id.game_genres)
            val genre = gameGenres.selectedItem.toString()

            val genreDesc = getGenreDesc(genre)

            val gamesList = getGames(genre)
            val reducedGamesList = gamesList.reduce {str, item->str + "\n" + item}

            val genreDescBox = findViewById<TextView>(R.id.genre_description)
            val games = findViewById<TextView>(R.id.games)

            genreDescBox.text = genreDesc
            games.text = reducedGamesList
        }
    }

    fun getGames(genre: String): List<String> {
        return when(genre) {
            "Action" -> listOf("Legend of Zelda", "GTA5")
            "Adventure" -> listOf("Final Fantasy", "Elden Ring")
            "Strategy" -> listOf("Age of Empires", "Starcraft")
            "Sports" -> listOf("FIFA22", "NBA2K22")
            "RPG" -> listOf("Elder Scrolls 4", "Fallout")
            else -> listOf("Super Mario", "Kirby")
        }
    }

    fun getGenreDesc(genre: String): String {
        val genreList = resources.getStringArray(R.array.game_genres)
        val genreDescList = resources.getStringArray(R.array.game_genres_desc)

        for(i in genreList.indices) {
            if(genreList[i] == genre) return genreDescList[i]
        }

        return ""
    }
}