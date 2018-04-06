package io.github.matthewcmckenna.owl.nano.features.video

import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
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
    override fun onCreate(savedInstanceState: Bundle?) {
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
        super.onStart()
        playerHolder.start()

        connector.setPlayer(playerHolder.player, null)
        mediaSession.isActive = true
    }

    override fun onStop() {
        super.onStop()
        playerHolder.stop()
        connector.setPlayer(null, null)
        mediaSession.isActive = false
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaSession.release()
        playerHolder.release()
    }

    override fun onUserLeaveHint() {
        Timber.d("onUserLeaveHint")
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
        Timber.d("isInPictureInPictureMode=$isInPictureInPictureMode")
        exoplayer_view.useController = !isInPictureInPictureMode
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
    }

}