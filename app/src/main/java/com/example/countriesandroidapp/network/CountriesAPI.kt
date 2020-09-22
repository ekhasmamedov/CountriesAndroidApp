package com.example.countriesandroidapp.network
import com.example.countriesandroidapp.models.Country
import io.reactivex.Observable
import retrofit2.http.GET

interface CountriesAPI {
    @GET("all")
    fun getAllCountries(): Observable<ArrayList<Country>>
}