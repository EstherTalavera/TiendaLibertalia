package com.ett.tienda.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ett.tienda.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1000)

        setTheme(R.style.Theme_Tienda)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}