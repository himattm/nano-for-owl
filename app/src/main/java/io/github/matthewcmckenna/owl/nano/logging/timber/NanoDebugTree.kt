package io.github.matthewcmckenna.owl.nano.logging.timber

import timber.log.Timber

class NanoDebugTree : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement?): String {
        return String.format("C:%s:%s",
                super.createStackElementTag(element),
                element?.lineNumber)
    }
}