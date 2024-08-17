package com.example.authen.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.authen.AuthenViewModel
import com.example.authen.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SignIn(viewModel: AuthenViewModel, navController: NavController){
    val email = remember { mutableStateOf("") }
    val pass = remember { mutableStateOf("") }

    val auth = FirebaseAuth.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign In", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(24.dp))
        textField(
            label = "Email",
            value = email.value,
            onVal = { email.value = it }
        )
        Spacer(modifier = Modifier.height(24.dp))
        textField(
            label = "Password",
            value = viewModel.email,
            onVal = { viewModel.emailChange(it) }
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            navController.navigate(Screen.homeScreen.route)
            if(email.value.isNotEmpty() && viewModel.pass.isNotEmpty()){
//                auth.signInWithEmail(email.value,pass.value)
            }
        }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = {
            navController.navigate(Screen.signUp.route)
        }) {
            Text("Don't have an Account? Sign Up")
        }
    }


}




@Composable
fun textField(label: String, value: String, onVal: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = { onVal },
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Preview(showBackground = true)
@Composable
fun SignInPreview(){
    SignIn(AuthenViewModel(), rememberNavController())
}