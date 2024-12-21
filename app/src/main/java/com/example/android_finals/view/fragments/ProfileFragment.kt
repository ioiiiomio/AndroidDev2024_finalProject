package com.example.android_finals.activities.com.example.android_finals.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.android_finals.R
import com.example.android_finals.databinding.FragmentProfileBinding
import com.example.android_finals.model.api.ApiSourceUser
import com.example.android_finals.model.api.RegisterRequest
import com.example.android_finals.view.util.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
//        updateUI(userData)

        // Set a click listener on the actionButton to toggle the authorization state
//        binding.registerButton.setOnClickListener {
//            val newAuthorizationState = !userData.isAuthorized()
//            userData.setAuthorizationState(newAuthorizationState)
//            updateUI(userData)
//        }

        binding.registerButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (name.isNotBlank() && password.isNotBlank()) {
                registerUser(name, password)
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

    // Update UI based on the current authorization state
//    private fun updateUI(userData: UserData) {
//        with(binding) {
//            if (userData.isAuthorized()) {
//                welcomeText.isVisible = true
//            } else {
//                welcomeText.isVisible = false
//            }
//        }
//    }


    private fun registerUser(name: String, password: String) {
        lifecycleScope.launch {
            try {
                val response = ApiSourceUser.api.registerUser(
                    RegisterRequest(name, password)
                )
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            requireContext(),
                            "Registration successful: ${response.body()?.username}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Registration failed", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}
