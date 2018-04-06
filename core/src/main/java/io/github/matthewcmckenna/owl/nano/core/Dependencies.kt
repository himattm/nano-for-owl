package io.github.matthewcmckenna.owl.nano.core

object Versions {
    const val support_lib = "27.1.0"
    const val retrofit = "2.3.0"
    const val rxjava = "2.1.9"
}

object Libs {
    const val support_annotations = "com.android.support:support-annotations:${Versions.support_lib}"
    const val support_appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support_lib}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
}