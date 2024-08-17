package com.example.authen

import androidx.compose.runtime.Composable
import com.google.firebase.auth.FirebaseAuth


val auth = FirebaseAuth.getInstance()

@Composable
fun signInWithEmail(email: String, password: String) {
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success
            } else {
                // Sign in failure
            }
        }
}