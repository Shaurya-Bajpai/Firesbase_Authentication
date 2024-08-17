package com.example.authen.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.authen.AuthenViewModel
import com.example.authen.navigation.Screen


@Composable
fun SignUp(
    viewModel: AuthenViewModel,
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign Up", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(24.dp))
        textField(
            label = "Email",
            value = viewModel.email,
            onVal = { viewModel.emailChange(it) }
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
        }) {
            Text(text = "Create Account")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = {
            navController.navigate(Screen.signIn.route)
        }) {
            Text("Already have an Account? Sign In")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUp(AuthenViewModel(), rememberNavController())
}
