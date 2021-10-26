package tdtu.seminar.rolldice

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CREATE BACKGROUND SOUND WHEN OPEN APP
        val playBtnSound: MediaPlayer = MediaPlayer.create(this, R.raw.play_click)
        val backgroundSound: MediaPlayer = MediaPlayer.create(this, R.raw.dice_sound_bg)

        val audioManger: AudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        audioManger.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0)


        backgroundSound.start()
        val playButton: Button = findViewById(R.id.btnPlay)
        playButton.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            playBtnSound.start()
            backgroundSound.pause()
        }

    }

}



