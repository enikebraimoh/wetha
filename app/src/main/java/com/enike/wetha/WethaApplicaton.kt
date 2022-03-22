package com.enike.wetha

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WethaApplicaton : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}