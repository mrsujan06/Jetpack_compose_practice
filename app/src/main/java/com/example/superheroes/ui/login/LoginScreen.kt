package com.example.superheroes.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.R
import com.example.superheroes.ui.theme.Purple500


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
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

                UserPhoto()

                Spacer(Modifier.padding(10.dp))

                EmailField(email, onEmailChange)

                Spacer(Modifier.padding(4.dp))

                PasswordField(password, onPasswordChange)

                Spacer(Modifier.padding(20.dp))

                LoginButton(onLoginClicked)

        }
    }

@Composable
fun EmailField(email: String, onEmailChange: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Purple500
        ),
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
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Purple500
        ),
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

@Composable
fun UserPhoto() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .border(
                border = BorderStroke(2.dp, color = Color(R.color.purple_500)),
                shape = CircleShape
            )
            .fillMaxWidth(),
        shape = CircleShape
    ) {

        Image(
            painter = painterResource(id = R.drawable.luffy),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )

    }
}

@Composable
fun LoginTopBar(title: String) {

    TopAppBar(title = {
        Text(title)
    },
        navigationIcon = {
            Icon(Icons.Filled.Menu, contentDescription = null)
        }
    )

}

@Composable
fun BackgroundImage() {
    val image: Painter = painterResource(id = R.drawable.backgound)
    Image(painter = image, contentDescription = null, contentScale = ContentScale.FillHeight)
}


@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        LoginScreen()
    }
}