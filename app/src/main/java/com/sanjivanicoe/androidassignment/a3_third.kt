package com.example.assignment

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sanjivanicoe.androidassignment.R

class a3_third : AppCompatActivity() {

    private lateinit var finalTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a3_third)

        // Handle window insets for proper padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize finalTextView
        finalTextView = findViewById(R.id.finalTextView)

        // Retrieve and display the final data from the Intent
        val finalData = intent.getStringExtra("finalData")
        finalTextView.text = finalData
    }
}