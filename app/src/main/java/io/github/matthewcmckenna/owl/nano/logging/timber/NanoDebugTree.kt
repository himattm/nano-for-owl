package io.github.matthewcmckenna.owl.nano.logging.timber

import timber.log.Timber
import java.util.*
import java.util.regex.Pattern

class NanoDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String {
        return String.format(Locale.getDefault(), "(%s:%d)", element.fileName, +element.lineNumber)
    }
}
