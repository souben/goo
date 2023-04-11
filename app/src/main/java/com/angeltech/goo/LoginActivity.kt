package com.angeltech.goo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        username = findViewById<EditText>(R.id.username)
        password = findViewById<EditText>(R.id.password)
        button = findViewById<Button>(R.id.button)

        println(username.text)
        println(password.text)

        button.setOnClickListener {
            GlobalScope.launch {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }


}