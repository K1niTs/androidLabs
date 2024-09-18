package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SigninActivity : AppCompatActivity() {

    private val TAG = "SigninActivity"
    private val correctEmail = "1"
    private val correctPassword = "1"
    private val REQUEST_SIGN_UP = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        Log.d(TAG, "onCreate")

        val emailInput: EditText = findViewById(R.id.email_input)
        val passwordInput: EditText = findViewById(R.id.password_input)
        val errorMessage: TextView = findViewById(R.id.error_message)
        val signinButton: Button = findViewById(R.id.signin_button)
        val registerButton: Button = findViewById(R.id.register_button)

        signinButton.setOnClickListener {
            val enteredEmail = emailInput.text.toString()
            val enteredPassword = passwordInput.text.toString()

            if (enteredEmail == correctEmail && enteredPassword == correctPassword) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                errorMessage.visibility = TextView.VISIBLE
            }
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, REQUEST_SIGN_UP)
        }

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                errorMessage.visibility = TextView.GONE
            }

            override fun afterTextChanged(s: Editable?) {}
        }

        emailInput.addTextChangedListener(textWatcher)
        passwordInput.addTextChangedListener(textWatcher)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_SIGN_UP && resultCode == RESULT_OK) {
            val name = data?.getStringExtra("USER_NAME")
            val email = data?.getStringExtra("USER_EMAIL")
            val password = data?.getStringExtra("USER_PASSWORD")
            val user = data?.getSerializableExtra("USER_OBJECT") as? User

            Log.d(TAG, "User registered: $name, $email, $password")
            Log.d(TAG, "User object: $user")

            findViewById<EditText>(R.id.email_input).setText(email)
            findViewById<EditText>(R.id.password_input).setText(password)
        }
    }
}