package com.codechanllenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codechanllenge.databinding.ActivityHomeBinding

const val USERNAME_KEY = "userName"
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =  ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.userName = "Hello ${intent?.extras?.getString(USERNAME_KEY)}"
    }
}