package com.example.assignment

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sanjivanicoe.androidassignment.R

class Assignment4 : AppCompatActivity() {

    private var counter = 0 // Counter for Button 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_assignment4)

        // Handle window insets for proper padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize Views
        val textView = findViewById<TextView>(R.id.textView)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        // Button 1: Change Text of TextView
        button1.setOnClickListener {
            counter++
            textView.text = "Button clicked $counter times"
        }

        // Button 2: Change Height of TextView
        button2.setOnClickListener {
            val newHeight = textView.layoutParams.height + 50
            textView.layoutParams = textView.layoutParams.apply {
                height = newHeight
            }
            textView.requestLayout() // Apply changes
        }

        // Button 3: Center TextView on the Screen
        button3.setOnClickListener {
            val layoutParams = textView.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.topMargin = 0
            layoutParams.bottomMargin = 0
            textView.layoutParams = layoutParams
            textView.gravity = Gravity.CENTER
        }
    }
}

