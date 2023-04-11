package com.angeltech.goo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var helloInput : EditText
    lateinit var helloText : TextView
    lateinit var doneButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doneButton = findViewById<Button>(R.id.doneButton)
        helloText = findViewById<TextView>(R.id.helloText)
        helloInput = findViewById<EditText>(R.id.helloInput)

        doneButton.setOnClickListener {
            getUsername(it)
        }

    }

    private fun getUsername(view : View) {
        val username = helloInput.text.toString()
        if (username != "" ){
            helloInput.visibility = View.GONE
            helloText.text = username
            helloText.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


}