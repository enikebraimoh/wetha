package com.enike.wetha.presentation.ui

enum class Screens {
    HomeScreen,
    WeatherDetailsScreen;

    companion object {
        fun fromRoute(route: String?): Screens =
            when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                WeatherDetailsScreen.name -> WeatherDetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }

}
