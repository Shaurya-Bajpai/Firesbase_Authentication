package com.example.authen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AuthenViewModel(): ViewModel() {
    var email by mutableStateOf("")
    var pass by mutableStateOf("")

    fun emailChange(newString: String){
        email = newString
    }
    fun passChange(newString: String){
        pass = newString
    }
}