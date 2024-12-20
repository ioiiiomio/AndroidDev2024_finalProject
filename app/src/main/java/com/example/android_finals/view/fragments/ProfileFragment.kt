package com.example.android_finals.activities.com.example.android_finals.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.android_finals.R
import com.example.android_finals.databinding.FragmentProfileBinding
import com.example.android_finals.view.util.UserData

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userData = UserData(requireContext())

        // Check the current authorization state
        updateUI(userData)

        // Set a click listener on the actionButton to toggle the authorization state
        binding.actionButton.setOnClickListener {
            // Toggle the authorization state
            val newAuthorizationState = !userData.isAuthorized()
            userData.setAuthorizationState(newAuthorizationState)
            updateUI(userData)
        }
    }

    // Update UI based on the current authorization state
    private fun updateUI(userData: UserData) {
        with(binding) {
            if (userData.isAuthorized()) {
                welcomeText.isVisible = true
            } else {
                welcomeText.isVisible = false
            }
        }
    }
}
