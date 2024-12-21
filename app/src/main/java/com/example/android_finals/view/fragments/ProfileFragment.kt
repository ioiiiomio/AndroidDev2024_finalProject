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
import com.example.android_finals.model.entity.User
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

        if (userData.isAuthorized()) {
            showProfileLayout(userData)
        } else {
            showRegistrationLayout()
        }

        binding.logIn.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (name.isNotEmpty() && password.isNotEmpty()) {
                lifecycleScope.launch {
                    handleRegistrationOrLogin(name, password, userData)
                }
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.logOut.setOnClickListener {
            userData.setAuthorizationState(false)
            showRegistrationLayout()
        }


    }



    private suspend fun handleRegistrationOrLogin(username: String, password: String, userData: UserData) {
        try {
            val users = fetchUsers() // Fetch all users from the API
            val existingUser = users?.find { it.username == username }

            if (existingUser != null) {
                // User exists, validate the password
                if (existingUser.password == password) {
                    // Successful login
                    userData.setAuthorizationState(true)
                    userData.setUsername(username)
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Login successful!", Toast.LENGTH_SHORT).show()
                        showProfileLayout(userData)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Incorrect password!", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                // New user, register them
                val response = ApiSourceUser.api.registerUser(RegisterRequest(username, password))
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        userData.setAuthorizationState(true)
                        userData.setUsername(username)
                        Toast.makeText(requireContext(), "Registration successful!", Toast.LENGTH_SHORT).show()
                        showProfileLayout(userData = userData)
                    } else {
                        Toast.makeText(requireContext(), "Registration failed!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), "An error occurred: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private suspend fun fetchUsers(): List<User>? {
        return try {
            val response = ApiSourceUser.api.fetchUsers()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }


    private fun showRegistrationLayout() {
        binding.registerForm.isVisible = true
        binding.profile.isVisible = false
    }

    private fun showProfileLayout(userData: UserData) {
        binding.registerForm.isVisible = false
        binding.profile.isVisible = true

        binding.username.text = userData.getUsername()
        userData.setAuthorizationState(true)
    }

}
