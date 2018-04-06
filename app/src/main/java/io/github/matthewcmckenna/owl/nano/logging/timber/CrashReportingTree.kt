package io.github.matthewcmckenna.owl.nano.logging.timber

import android.util.Log
import timber.log.Timber

class CrashReportingTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }
//        TODO("Crash Library").log(priority, tag, message);
//        if (t != null) {
//            if (priority == Log.ERROR) {
//                TODO("Crash Library")Library.logError(t)
//            } else if (priority == Log.WARN) {
//                TODO("Crash Library").logErrorWarning(t)
//            }
//        }
    }
}