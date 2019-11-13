package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LocalBroadcastManager.getInstance(this).registerReceiver(broadCastReceiver, IntentFilter("main_activity"));
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
    fun send(view: View) {
        val intent = Intent(this, MainIntentService::class.java)
        intent.putExtra("com.example.myapplication", inputNumber.text.toString().toInt())
        this.startService(intent)
        button.isEnabled = false;
    }

    val broadCastReceiver = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context?, intent: Intent?) {
            val quantity = intent?.getIntExtra("quantity", 0)
            val numbers = intent?.getStringExtra("result")
            sizeNumbers.text = quantity.toString()
            scrollableText.text = numbers
            button.isEnabled = true
        }
    }
}
