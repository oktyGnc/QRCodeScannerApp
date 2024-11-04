package com.oktaygenc.qrcodescannerapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.oktaygenc.qrcodescannerapp.databinding.ActivityHomeBinding
import com.oktaygenc.qrcodescannerapp.databinding.ActivityMainBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartScanner.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}