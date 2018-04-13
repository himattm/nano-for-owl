package io.github.matthewcmckenna.owl.nano.android

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import io.github.matthewcmckenna.owl.nano.BuildConfig
import io.github.matthewcmckenna.owl.nano.logging.timber.NanoDebugTree
import io.github.matthewcmckenna.owl.nano.logging.timber.NoLogTree
import timber.log.Timber

class NanoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppCenter.start(
                this,
                "",
                Analytics::class.java,
                Crashes::class.java)

        if (BuildConfig.DEBUG) {
            Timber.plant(NanoDebugTree())
        } else {
            Timber.plant(NoLogTree())
        }
    }
}