package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sanjivanicoe.androidassignment.R

class A3_Second : AppCompatActivity() {
    private lateinit var displayTextView: TextView
    private lateinit var buttonSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a3_second)

        displayTextView = findViewById(R.id.displayTextView)
        buttonSend = findViewById(R.id.buttonSend)

        // Retrieve data from Intent
        val receivedText1 = intent.getStringExtra("key1")
        val receivedText2 = intent.getStringExtra("key2")
        val receivedText3 = intent.getStringExtra("key3")
        val receivedText4 = intent.getStringExtra("key4")
        val receivedText5 = intent.getStringExtra("key5")
        val booleanValue = intent.getBooleanExtra("booleanKey", false)
        val intValue = intent.getIntExtra("intKey", 0)
        val floatValue = intent.getFloatExtra("floatKey", 0f)

        // Log the retrieved values
        Log.d("SecondActivity", "Received Text: $receivedText1, $receivedText2, $receivedText3, $receivedText4, $receivedText5")
        Log.d("SecondActivity", "Boolean: $booleanValue, Int: $intValue, Float: $floatValue")

        // Display one of the strings in the TextView
        displayTextView.text = "Received: $receivedText1, $receivedText2, $receivedText3, $receivedText4, $receivedText5"

        buttonSend.setOnClickListener {
            val finalData = "Received: $receivedText1, $receivedText2, $receivedText3, $receivedText4, $receivedText5, Boolean: $booleanValue, Int: $intValue, Float: $floatValue"
            val intent = Intent(this, a3_third::class.java)
            intent.putExtra("finalData", finalData)
            startActivity(intent)
        }
    }
}