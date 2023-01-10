package de.syntax_institut.filmestreamingservice

import android.os.Bundle
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import de.syntax_institut.filmestreamingservice.adapter.ItemAdapter
import de.syntax_institut.filmestreamingservice.data.Datasource
import de.syntax_institut.filmestreamingservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /**
     * Die lifecycle onCreate Methode
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // recyclerView von Layout wird mit code verknüpft
        val recyclerView = binding.recyclerView

        // Liste aus Filmtiteln wird von der Datasource geladen
        // TODO Schreibe hier deinen Code

        val datasource = Datasource(this).loadMovies()

        // recyclerView erhält einen passenden LayoutManager
        // TODO Schreibe hier deinen Code
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)

        // ItemAdapter wird als Adapter festgelegt
        // TODO Schreibe hier deinen Code
        val adapter = ItemAdapter ( this, datasource )

        recyclerView.adapter = adapter

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)
    }
}