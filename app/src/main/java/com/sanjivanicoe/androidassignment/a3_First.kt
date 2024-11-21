package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sanjivanicoe.androidassignment.R

class A3_First : AppCompatActivity() {
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a3_first)

        // Set up window insets for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        button = findViewById(R.id.button)

        // Set strings to TextViews
        textView1.text = getString(R.string.string1)
        textView2.text = getString(R.string.string2)
        textView3.text = getString(R.string.string3)
        textView4.text = getString(R.string.string4)
        textView5.text = getString(R.string.string5)

        button.setOnClickListener {
            val intent = Intent(this, A3_Second::class.java)
            intent.putExtra("key1", textView1.text.toString())
            intent.putExtra("key2", textView2.text.toString())
            intent.putExtra("key3", textView3.text.toString())
            intent.putExtra("key4", textView4.text.toString())
            intent.putExtra("key5", textView5.text.toString())
            intent.putExtra("booleanKey", true)
            intent.putExtra("intKey", 42)
            intent.putExtra("floatKey", 3.14f)

            startActivity(intent)
        }
    }
}