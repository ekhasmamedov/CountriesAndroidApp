package com.example.countriesandroidapp.network

import com.example.countriesandroidapp.models.Country
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

class CountriesService @Inject constructor(
    private val countriesAPI: CountriesAPI
) {
    fun fetchAllCountries(): Observable<ArrayList<Country>> {
        return countriesAPI.getAllCountries()
    }
}