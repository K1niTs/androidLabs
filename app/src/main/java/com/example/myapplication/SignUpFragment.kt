package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentSignupBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!
    private val TAG = "SignUpFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)

        binding.registerButton.setOnClickListener {
            val name = binding.nameInput.text.toString()
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()

            if (name.isNotBlank() && email.isNotBlank() && password.isNotBlank()) {
                val user = User(name, email, password)
                (activity as MainActivity).onUserRegistered(user)
            } else {
                Log.d(TAG, "Registration failed: Fields cannot be empty")
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
