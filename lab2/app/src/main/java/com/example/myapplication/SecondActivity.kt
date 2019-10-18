package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textQuestion.text = intent.getStringExtra("message")
    }

    fun answer(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("message", editAnswer.text.toString())
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
