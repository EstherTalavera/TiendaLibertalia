package com.estata.libertalia.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.estata.libertalia.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1000)

        setTheme(R.style.Theme_Libertalia)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}