package io.github.matthewcmckenna.owl.nano.features.video

data class PlayerState(var window: Int = 0,
                       var position: Long = 0,
                       var whenReady: Boolean = true,
                       var source: SourceType = SourceType.HTTP_VIDEO)