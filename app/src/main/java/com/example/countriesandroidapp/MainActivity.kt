package com.example.countriesandroidapp

import android.app.Activity
import android.os.Bundle
import android.widget.ListView
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.countriesandroidapp.network.CountriesService
import com.example.countriesandroidapp.ui.home.CountriesListAdapter
import com.example.countriesandroidapp.ui.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import javax.inject.Inject
import androidx.lifecycle.Observer

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