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
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentSigninBinding

class SignInFragment : Fragment() {

    private var _binding: FragmentSigninBinding? = null
    private val binding get() = _binding!!
    private val args: SignInFragmentArgs by navArgs()
    private val TAG = "SignInFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSigninBinding.inflate(inflater, container, false)
        Log.d(TAG, "onCreateView")

        binding.emailInput.setText(args.userEmail)
        binding.passwordInput.setText(args.userPassword)

        binding.signinButton.setOnClickListener {
            val enteredEmail = binding.emailInput.text.toString()
            val enteredPassword = binding.passwordInput.text.toString()

            if (enteredEmail == "1" && enteredPassword == "1") {
                (activity as MainActivity).navigateToHome()
            } else {
                binding.errorMessage.visibility = TextView.VISIBLE
            }
        }

        binding.registerButton.setOnClickListener {
            (activity as MainActivity).navigateToSignUp()
        }

        binding.emailInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.errorMessage.visibility = TextView.GONE
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        binding.passwordInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.errorMessage.visibility = TextView.GONE
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
