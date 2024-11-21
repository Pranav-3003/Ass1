package com.example.assignment

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sanjivanicoe.androidassignment.R

class Assignment2 : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    private var originalHeight: Int = 0 // Store the original height
    private var isHeightChanged = false // Track the height state

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_assignment2)

        // Set up window insets for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        textView = findViewById(R.id.textView)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        // Store the original height of the TextView
        originalHeight = textView.height

        // Set click listeners
        button1.setOnClickListener { changeText() }
        button2.setOnClickListener { changeHeight() }
        button3.setOnClickListener { centerText() }
    }

    private fun changeText() {
        textView.text = "Text Changed!"
    }

    private fun changeHeight() {
        val params = textView.layoutParams
        if (isHeightChanged) {
            params.height = originalHeight // Reset to original height
            isHeightChanged = false
        } else {
            params.height = 300 // Set height to 300 pixels
            isHeightChanged = true
        }
        textView.layoutParams = params
    }

    private fun centerText() {
        textView.gravity = android.view.Gravity.CENTER // Center the text
    }
}