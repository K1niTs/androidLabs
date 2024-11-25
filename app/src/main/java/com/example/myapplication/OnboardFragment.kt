package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentOnboardBinding

class OnboardFragment : Fragment() {

    private var _binding: FragmentOnboardBinding? = null
    private val binding get() = _binding!!
    private val TAG = "OnboardFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardBinding.inflate(inflater, container, false)
        Log.d(TAG, "onCreateView")

        binding.nextButton.setOnClickListener {
            (activity as MainActivity).navigateToSignIn()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
