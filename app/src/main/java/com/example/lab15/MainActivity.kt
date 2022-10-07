package com.example.lab15

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnSlow = findViewById<Button>(R.id.btnSlow)
        var ivBox = findViewById<ImageView>(R.id.ivBox)

        btnSlow.setOnClickListener {
            val mp = MediaPlayer.create(baseContext, R.raw.fast)
            btnSlow.isEnabled = false
            val myTimer = object : CountDownTimer(5250, 100) {
                override fun onTick(l: Long) {
                    mp.start()
                }
                override fun onFinish() {
                    ivBox.setImageResource(R.drawable.jack_open)
                }
            }
            mp.setOnCompletionListener {
                ivBox.setImageResource(R.drawable.jack_closed)
                btnSlow.isEnabled = true
            }
            myTimer.start()
        }
    }
}