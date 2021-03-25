package com.example.superheroes.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.R

@Composable
fun LoginScreen() {

    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }

    LoginContent(
        email = email,
        password = password,
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        onLoginClicked = {}
    )
}

@Composable
fun LoginContent(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        EmailField(email, onEmailChange)

        Spacer(Modifier.padding(4.dp))

        PasswordField(password, onPasswordChange)

        Spacer(Modifier.padding(25.dp))

        LoginButton(onLoginClicked)

    }

}

@Composable
fun EmailField(email: String, onEmailChange: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        label = { Text("Email") },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = null
            )
        }
    )
}

@Composable
fun PasswordField(password: String, onPasswordChange: (String) -> Unit) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_password),
                contentDescription = null
            )
        }
    )
}

@Composable
fun LoginButton(onLoginClicked: () -> Unit) {
    Button(
        modifier = Modifier
            .width(150.dp)
            .height(45.dp),
        onClick = onLoginClicked,
        shape = MaterialTheme.shapes.medium
    ) {
        Text("Login")
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        LoginScreen()
    }
}