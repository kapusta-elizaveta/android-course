package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10) {
            textViewAnswer.text = data?.getStringExtra("message")
        }
    }

    fun question(view: View){
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("message", textViewAnswer.text.toString())
        }
        startActivityForResult(intent, 10)
    }
}
