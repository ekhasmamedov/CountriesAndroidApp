package com.example.countriesandroidapp.ui.home

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countriesandroidapp.models.Country
import com.example.countriesandroidapp.network.CountriesService
import com.example.countriesandroidapp.network.NetworkModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.collections.ArrayList

class HomeViewModel @ViewModelInject constructor(
    private val countriesService: CountriesService
): ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _countries = MutableLiveData<ArrayList<Country>>()
    val countries: LiveData<ArrayList<Country>> = _countries

    fun loadCountries() {
        compositeDisposable.add(countriesService.fetchAllCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { value -> _countries.value = value },
                { error -> Log.e("HomeViewModel","Error: $error") },
                { Log.v("HomeViewModel","Completed") }
            ))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}