package io.github.matthewcmckenna.owl.nano.features.video

import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.media.session.MediaSessionCompat
import android.support.v7.app.AppCompatActivity
import android.util.Rational
import android.view.View
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector
import io.github.matthewcmckenna.owl.nano.R.layout.player_activity
import kotlinx.android.synthetic.main.player_activity.*
import timber.log.Timber


class PlayerActivity : AppCompatActivity() {

    private lateinit var playerHolder: PlayerHolder
    private val state = PlayerState()

    private lateinit var mediaSession: MediaSessionCompat
    private lateinit var connector: MediaSessionConnector

    private var showControls = true
    private var playbackPosition = 0L

    private val KEY_SHOW_CONTROLS = "KEY_SHOW_CONTROLS"
    private val KEY_PLAYBACK_POSITION = "KEY_PLAYBACK_POSITION"

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.v("onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(player_activity)

        mediaSession = MediaSessionCompat(this, "io.github.matthewcmckenna.owl.nano.features.video")
        connector = MediaSessionConnector(mediaSession)

        playerHolder = PlayerHolder(this, exoplayer_view, state)

        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE)
    }

    override fun onStart() {
        Timber.v("onStart()")
        super.onStart()
        playerHolder.start()

        connector.setPlayer(playerHolder.player, null)
        mediaSession.isActive = true
    }

    override fun onResume() {
        Timber.v("onResume()")
        super.onResume()
    }

    override fun onPause() {
        Timber.v("onPause()")
        super.onPause()
    }

    override fun onStop() {
        Timber.v("onStop()")
        super.onStop()
        playerHolder.stop()
        connector.setPlayer(null, null)
        mediaSession.isActive = false
    }

    override fun onDestroy() {
        Timber.v("onDestroy()")
        super.onDestroy()
        mediaSession.release()
        playerHolder.release()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Timber.v("onSaveInstanceState( $outState )")
        super.onSaveInstanceState(outState)
        Timber.d("saving showControls=$showControls, playbackPosition=$playbackPosition")
        outState?.putBoolean(KEY_SHOW_CONTROLS, showControls)
        outState?.putLong(KEY_PLAYBACK_POSITION, playbackPosition)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Timber.v("onRestoreInstanceState( $savedInstanceState )")
        super.onRestoreInstanceState(savedInstanceState)
        showControls = savedInstanceState?.getBoolean(KEY_SHOW_CONTROLS) ?: true
        playbackPosition = savedInstanceState?.getLong(KEY_PLAYBACK_POSITION) ?: 0

        exoplayer_view.useController = showControls
        playerHolder.player.seekTo(playbackPosition)
        Timber.d("showControls=$showControls, playbackPosition=$playbackPosition")
    }

    override fun onUserLeaveHint() {
        Timber.v("onUserLeaveHint()")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            enterPictureInPictureMode(
                    with(PictureInPictureParams.Builder()) {
                        val width = 16
                        val height = 9
                        setAspectRatio(Rational(width, height))
                        build()
                    }
            )
        }
    }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean, newConfig: Configuration?) {
        Timber.v("onPictureInPictureModeChanged( $isInPictureInPictureMode )")
        Timber.d("before showControls=$showControls, playbackPosition=$playbackPosition")
        showControls = !isInPictureInPictureMode
        playbackPosition = playerHolder.player.currentPosition
        Timber.d("after showControls=$showControls, playbackPosition=$playbackPosition")
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
    }

}
