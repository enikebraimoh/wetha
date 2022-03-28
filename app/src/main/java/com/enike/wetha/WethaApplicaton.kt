package com.enike.wetha

import android.app.Application
import android.os.Build
import androidx.work.*
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

            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .apply {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setRequiresDeviceIdle(false)
                    }
                }.build()

            val repeatingRequest =
                PeriodicWorkRequestBuilder<FavouriteWeatherWorker>(
                    1,
                    TimeUnit.HOURS
                ).setConstraints(constraints)
                    .build()

            WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
                FavouriteWeatherWorker.WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                repeatingRequest
            )
        }
    }

}