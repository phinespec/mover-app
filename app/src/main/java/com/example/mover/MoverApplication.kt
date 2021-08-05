package com.example.mover

import android.app.Application
import timber.log.Timber

class MoverApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}