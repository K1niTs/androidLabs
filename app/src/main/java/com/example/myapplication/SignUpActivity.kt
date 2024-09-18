package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignUpActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val nameInput: EditText = findViewById(R.id.name_input)
        val emailInput: EditText = findViewById(R.id.email_input)
        val passwordInput: EditText = findViewById(R.id.password_input)
        val registerButton: Button = findViewById(R.id.register_button)

        registerButton.setOnClickListener {
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            val resultIntent = Intent().apply {
                putExtra("USER_NAME", name)
                putExtra("USER_EMAIL", email)
                putExtra("USER_PASSWORD", password)
                putExtra("USER_OBJECT", User(name, email, password))
            }

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
