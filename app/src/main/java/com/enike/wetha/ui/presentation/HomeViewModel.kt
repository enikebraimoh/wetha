package com.enike.wetha.ui.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enike.core.DataState
import com.enike.core.domain.City
import com.enike.wetha.framework.network.GetCityWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor
    (private val getWeatherUseCase: GetCityWeatherUseCase) : ViewModel() {

    private val _state = mutableStateOf("")
    val state: State<String> = _state

    val cit = listOf("london", "adaad")

    init {
        getCityWeather(cit[0])
    }

    var isLastIndex = false

    private fun getCityWeather(country: String) {

        getWeatherUseCase(country).onEach { state ->
            when (state) {
                is DataState.Success<City> -> {
                    Log.d("MYTEST_Viewmodel", state.data.toString())
                }
                is DataState.Error -> {

                    Log.d("MYTEST_Viewmodel", state.error.toString())
                }
                is DataState.GenericError -> {

                    Log.d("MYTEST_Viewmodel", state.error.toString())
                }
                DataState.Loading -> {

                }
            }
        }.launchIn(viewModelScope)
    }

}