package io.github.matthewcmckenna.owl.nano.android

import android.app.Application
import io.github.matthewcmckenna.owl.nano.BuildConfig
import io.github.matthewcmckenna.owl.nano.logging.timber.NanoDebugTree
import io.github.matthewcmckenna.owl.nano.logging.timber.NoLogTree
import timber.log.Timber

class NanoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(NanoDebugTree())
        } else {
            Timber.plant(NoLogTree())
        }
    }
}