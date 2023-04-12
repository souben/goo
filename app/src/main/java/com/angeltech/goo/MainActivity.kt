package com.angeltech.goo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.angeltech.goo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener {
            getUsername(it)
        }

        var intro = Intro("Job", "Software engineer")
        binding.intro = intro
    }

    private fun getUsername(view : View) {
        val username = binding.helloInput.text
        if (username.toString() != "" ) {
            binding.apply {
                invalidateAll()
                helloInput.visibility = View.GONE
                helloText.text = username
                helloText.visibility = View.VISIBLE
            }
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


}