package com.example.locationzips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.locationzips.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Creating a binding object for the main_activity.xml layout

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}