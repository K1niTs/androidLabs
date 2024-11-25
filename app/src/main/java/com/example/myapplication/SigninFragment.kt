package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class SignInFragment : Fragment() {

    private val TAG = "SignInFragment"
    private val correctEmail = "1"
    private val correctPassword = "1"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signin, container, false)
        Log.d(TAG, "onCreateView")

        val emailInput: EditText = view.findViewById(R.id.email_input)
        val passwordInput: EditText = view.findViewById(R.id.password_input)
        val errorMessage: TextView = view.findViewById(R.id.error_message)
        val signinButton: Button = view.findViewById(R.id.signin_button)
        val registerButton: Button = view.findViewById(R.id.register_button)

        signinButton.setOnClickListener {
            val enteredEmail = emailInput.text.toString()
            val enteredPassword = passwordInput.text.toString()

            if (enteredEmail == correctEmail && enteredPassword == correctPassword) {
                (activity as MainActivity).navigateToHome()
            } else {
                errorMessage.visibility = TextView.VISIBLE
            }
        }

        registerButton.setOnClickListener {
            (activity as MainActivity).navigateToSignUp()
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

        return view
    }

    // Метод для получения результата из SignUpFragment
    fun handleSignUpResult(name: String?, email: String?, password: String?, user: User?) {
        Log.d(TAG, "User registered: $name, $email, $password")
        Log.d(TAG, "User object: $user")

        view?.findViewById<EditText>(R.id.email_input)?.setText(email)
        view?.findViewById<EditText>(R.id.password_input)?.setText(password)
    }
}
