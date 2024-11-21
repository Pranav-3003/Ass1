package com.example.assignment

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sanjivanicoe.androidassignment.R

class MainActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextContact: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Set up window insets for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        editTextName = findViewById(R.id.editTextName)
        editTextContact = findViewById(R.id.editTextPhone)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextAddress = findViewById(R.id.editTextAddress)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        // Set button click listener
        buttonSubmit.setOnClickListener { validateInput() }
    }

    private fun validateInput() {
        val name = editTextName.text.toString().trim()
        val contact = editTextContact.text.toString().trim()
        val email = editTextEmail.text.toString().trim()
        val password = editTextPassword.text.toString().trim()
        val address = editTextAddress.text.toString().trim()

        var valid = true

        if (TextUtils.isEmpty(name)) {
            editTextName.error = "Name cannot be empty"
            valid = false
        }

        if (TextUtils.isEmpty(contact) || contact.length != 10) {
            editTextContact.error = "Contact must be 10 digits"
            valid = false
        } else if (!TextUtils.isDigitsOnly(contact)) {
            editTextContact.error = "Contact must be numeric"
            valid = false
        }

        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.error = "Enter a valid email"
            valid = false
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.error = "Password cannot be empty"
            valid = false
        }

        if (TextUtils.isEmpty(address)) {
            editTextAddress.error = "Address cannot be empty"
            valid = false
        }

        if (valid) {
            // Proceed with sign-up (e.g., save to database or API call)
            Toast.makeText(this, "Sign up successful!", Toast.LENGTH_SHORT).show()
        }
    }
}