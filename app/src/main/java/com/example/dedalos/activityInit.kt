package com.example.dedalos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dedalos.databinding.ActivityInitBinding
import com.example.dedalos.extensions.openActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class activityInit : AppCompatActivity() {

    private var binding: ActivityInitBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitBinding.inflate(layoutInflater).apply { setContentView(root) }
        supportActionBar?.hide()
        initDelay()
    }


    private fun initDelay(){
        val t = Timer()
        var counter = 0
        val tt: TimerTask = object : TimerTask() {
            override fun run() {
                counter++
//                binding?.progressBar?.progress = counter
                if (counter == 100){
                    CoroutineScope(Dispatchers.Main).launch {
                        openActivity<LogActivity>(finishWhenOpen = true)
                    }
                    t.cancel()
                }
            }
        }
        t.schedule(tt, 0, 50)
    }
}