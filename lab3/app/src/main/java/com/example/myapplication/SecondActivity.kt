package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_activity.*

class SecondActivity : AppCompatActivity() {
    private lateinit var fragment: FragmentImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textViewQuestion.text = intent.getStringExtra("message")
        answer()
    }

    fun answer() {
        this.fragment = supportFragmentManager.findFragmentById(R.id.inputAnswer) as FragmentImpl
        fragment.button.setOnClickListener {
            val intent = Intent().apply {
                putExtra("message", fragment.editText.text.toString())
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.close -> {
                val exitDialog = ExitDialog()
                exitDialog.show(supportFragmentManager, "dialog")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun finishAndRemoveTask() {
        val intent = Intent().apply {
            putExtra("complete", "complete")
        }
        setResult(Activity.RESULT_OK, intent)
        super.finishAndRemoveTask()
    }
}
