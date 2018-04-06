package io.github.matthewcmckenna.owl.nano.features.video

import android.content.Context
import android.media.AudioManager
import android.net.Uri
import android.support.v4.media.AudioAttributesCompat
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory


class PlayerHolder(private val context: Context,
                   private val playerView: PlayerView,
                   private val playerState: PlayerState) {

    val player: ExoPlayer

    init {
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val audioAttributes = AudioAttributesCompat.Builder()
                .setContentType(AudioAttributesCompat.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributesCompat.USAGE_MEDIA)
                .build()

        player = NanoPlayer(
                audioAttributes,
                audioManager,
                ExoPlayerFactory.newSimpleInstance(
                        DefaultRenderersFactory(context),
                        DefaultTrackSelector(),
                        DefaultLoadControl())
                        .also {
                            playerView.player = it
                        }
        )
    }

    fun start() {
        // Load media.
        player.prepare(buildMediaSource(selectMediaToPlay(playerState.source)))
        with(playerState) {
            // Start playback when media has buffered enough.
            player.playWhenReady = whenReady
            player.seekTo(window, position)
        }
    }

    fun stop() {
        with(player) {
            with(playerState) {
                position = currentPosition
                window = currentWindowIndex
                whenReady = playWhenReady
            }
            stop()
        }
    }

    fun release() {
        player.release()
    }

    fun selectMediaToPlay(source: SourceType): Uri {
        val testUrl = "https://mlgmsod-pipeline.akamaized.net/media/production/delivery/80/63/8063e1ad-ba6d-4cdd-a612-ff42fcdeb0d4/t64vhOG5lcy.RNhxOTIkqBkw.en-US.9632a417-8a39-43bb-9d71-5892cdfc4c814b8f451e-7a7e-336d-21b7-97b648c41960.m3u8"
        return when (source) {
            SourceType.LOCAL_AUDIO -> Uri.parse("asset:///audio/file.mp3")
            SourceType.LOCAL_VIDEO -> Uri.parse("asset:///video/file.mp4")
            SourceType.HTTP_AUDIO -> Uri.parse("http://site.../file.mp3")
            SourceType.HTTP_VIDEO -> Uri.parse(testUrl)
            else -> TODO("Not Implemented SourceType ${source.name}")
        }
    }

    private fun buildMediaSource(uri: Uri): MediaSource {
        return HlsMediaSource.Factory(DefaultDataSourceFactory(context, "videoapp")).createMediaSource(uri)
        //        return ExtractorMediaSource.Factory(DefaultDataSourceFactory(context, "videoapp")).createMediaSource(uri)
    }
}