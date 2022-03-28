package com.enike.wetha.utils

import android.app.NotificationManager
import android.content.Context
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext


class FavouriteWeatherWorker(private val context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    @InstallIn(SingletonComponent::class)
    @EntryPoint
    interface LogsContentProviderEntryPoint {
        fun usecase(): GetCityWeatherUseCase2
        fun usecase2(): GetCitiesFromDatabaseUseCase2
    }

    private fun getUseCase(appContext: Context): GetCityWeatherUseCase2 {
        val hiltEntryPoint = EntryPointAccessors.fromApplication(
            appContext,
            LogsContentProviderEntryPoint::class.java
        )
        return hiltEntryPoint.usecase()
    }

    private fun getUseCase2(appContext: Context): GetCitiesFromDatabaseUseCase2 {
        val hiltEntryPoint = EntryPointAccessors.fromApplication(
            appContext,
            LogsContentProviderEntryPoint::class.java
        )
        return hiltEntryPoint.usecase2()
    }

    companion object {
        const val WORK_NAME = "FavouriteWeatherWorker"
    }

    override suspend fun doWork(): Result {
        return try {
            withContext(Dispatchers.IO) {

                var cities = getUseCase2(applicationContext).invoke()

                cities.collect { city ->
                    if (city[0].favourite) {
                        val res = getUseCase(applicationContext).invoke(city = city[0].cityName)
                        res.collect { place ->
                            callNotification("The weather for ${place.cityName} is  ${place.weather[0].description}, temperature is ${place.temperature.temp}° ")
                        }
                    }

                }
                Result.success()
            }

        } catch (e: Exception) {
            Log.d("ERROR_TESTING_REPO", e.localizedMessage.toString())
            callNotification(e.localizedMessage.toString())
            Result.retry()
        }
    }

    private fun callNotification(place: String) {
        val notificationManager = ContextCompat.getSystemService(
            context,
            NotificationManager::class.java
        ) as NotificationManager

        notificationManager.sendNotification(
            place,
            context
        )
    }

}