package com.countriesandroidapp.ui

import android.os.Bundle
import android.widget.ListView
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer
import com.countriesandroidapp.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @VisibleForTesting
    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var listView: ListView
    private lateinit var adapter: CountriesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = countries_list_view

        homeViewModel.loadCountries()
        homeViewModel.countries.observe(this, Observer {
            adapter.setItems(it)
        })

        adapter = CountriesListAdapter(this, arrayListOf())
        listView.adapter = adapter
    }
}