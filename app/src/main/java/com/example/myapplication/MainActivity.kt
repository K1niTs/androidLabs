package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    fun navigateToSignIn() {
        navController.navigate(R.id.signInFragment)
    }

    fun navigateToSignUp() {
        navController.navigate(R.id.signUpFragment)
    }

    fun navigateToHome() {
        navController.navigate(R.id.homeFragment)
    }

    fun onUserRegistered(user: User) {
        val action = SignUpFragmentDirections.actionSignUpFragmentToSignInFragment(
            userEmail = user.email,
            userPassword = user.password
        )
        navController.navigate(action)
    }


    }

