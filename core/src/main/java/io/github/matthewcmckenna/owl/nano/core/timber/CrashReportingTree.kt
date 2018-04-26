package io.github.matthewcmckenna.owl.nano.core.timber

import android.util.Log
import com.microsoft.appcenter.analytics.Analytics
import timber.log.Timber

class CrashReportingTree : Timber.Tree() {
    init {
        Analytics.setEnabled(true)
    }

    override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        if (t != null) {
            val properties = mutableMapOf<String, String>()
            properties["priority"] = priority.toString()
            properties["priority_text"] = priorityToDescriptor(priority)
            tag?.let { properties.put("tag", it) }
            message?.let { properties.put("tag", it) }

            if (priority == Log.ERROR) {
//                Crashes.trackException(t, properties)
            } else if (priority == Log.WARN) {
//                Crashes.trackException(t, properties)
            }
        }
    }

    private fun priorityToDescriptor(priority: Int) =
            when (priority) {
                Log.VERBOSE -> "Verbose"
                Log.DEBUG -> "Debug"
                Log.INFO -> "Info"
                Log.WARN -> "Warn"
                Log.ERROR -> "Error"
                Log.ASSERT -> "Assert"
                else -> "Unknown Priority: $priority"
            }
}
