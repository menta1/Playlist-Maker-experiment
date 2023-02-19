package com.example.playlist_maker_experiment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.playlist_maker_experiment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.searchButton.setOnClickListener{
            val searchIntent = Intent(this, SearchActivity::class.java)
            startActivity(searchIntent)
        }
        mainBinding.mediatekaButton.setOnClickListener{
            val mediatekaIntent = Intent(this, MediatekaActivity::class.java)
            startActivity(mediatekaIntent)
        }

        mainBinding.settingsButton.setOnClickListener{
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            startActivity(settingsIntent)
        }

    }
}