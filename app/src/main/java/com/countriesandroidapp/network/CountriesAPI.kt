package com.countriesandroidapp.network
import com.countriesandroidapp.models.Country
import io.reactivex.Observable
import retrofit2.http.GET

interface CountriesAPI {
    @GET("all")
    fun getAllCountries(): Observable<ArrayList<Country>>
}