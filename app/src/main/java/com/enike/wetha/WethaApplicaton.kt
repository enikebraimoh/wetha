package com.enike.wetha

import android.app.Application
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.enike.wetha.utils.FavouriteWeatherWorker
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class WethaApplicaton : Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        doBackgroundWork()
    }

    fun doBackgroundWork() {
        applicationScope.launch {
            val repeatingRequest =
                PeriodicWorkRequestBuilder<FavouriteWeatherWorker>(1, TimeUnit.HOURS)
                    .build()

            WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
                FavouriteWeatherWorker.WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                repeatingRequest
            )
        }


    }

}