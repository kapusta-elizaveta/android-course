package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_activity.*

class MainActivity : AppCompatActivity() {
    private lateinit var fragment: FragmentImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        question()
    }

    fun question(){
        this.fragment = supportFragmentManager.findFragmentById(R.id.inputQuestion) as FragmentImpl
        fragment.button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("message", fragment.editText.text.toString())
            }
            startActivityForResult(intent, 10)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10) {
            if (resultCode == Activity.RESULT_OK) {
                if (data?.getStringExtra("complete").equals("complete")) {
                    finish()
                }
                textViewAnswer.text = data?.getStringExtra("message")
            }
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
}

