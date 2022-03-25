package com.enike.wetha.utils

import android.app.NotificationManager
import android.content.Context
import androidx.core.content.ContextCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.enike.core.interactors.GetCityWeatherUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class FavouriteWeatherWorker(private val context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    @Inject
    lateinit var usecase: GetCityWeatherUseCase

    val coroutines = CoroutineScope(Dispatchers.Default)

    companion object {
        const val WORK_NAME = "FavouriteWeatherWorker"
    }

    override suspend fun doWork(): Result {
        return try {
            val res = usecase("abuja")
            res.onEach { place ->
                callNotification("${place.cityName} ${place.favourite} ${place.temperature.temp}")
            }.launchIn(coroutines)
            return Result.success()
        } catch (e: Exception) {
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