package com.applecompose.thebook.presentation.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.applecompose.thebook.R
import com.applecompose.thebook.presentation.components.BookLogo
import com.applecompose.thebook.presentation.components.buttons.SubmitButton
import com.applecompose.thebook.presentation.components.emails.EmailInput
import com.applecompose.thebook.presentation.components.password.PasswordInput

@Composable
fun LoginScreen(navController: NavController) {
	val showLoginForm = rememberSaveable { mutableStateOf(true) }
	Surface(
		modifier = Modifier
			.fillMaxSize()
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Top
		) {
			BookLogo()
			if (showLoginForm.value) UserForm(
				loading = false,
				isCreateAccount = false
			) { email, password -> }
			// todo FB Login
			else {
				UserForm(
					loading = false,
					isCreateAccount = true,) { email, password -> }
				//todo firebase account


			}
			Spacer(modifier = Modifier.height(6.dp))
			Row(
				modifier = Modifier
					.padding(6.dp),
				horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.Top
			) {
				val text = if (showLoginForm.value) "Sign Up" else "Login"
				Text(
					text = "NewUser?",
					fontSize = 20.sp
					)
				Spacer(modifier = Modifier.width(16.dp))
				Text(
					text = text,

					style = TextStyle(
						MaterialTheme.colors.primary,
						fontSize = 20.sp
						),
					modifier = Modifier
						.clickable {
							showLoginForm.value = !showLoginForm.value
						}
					)

			}
		}

	}
}


@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun UserForm(
	loading: Boolean = false,
	isCreateAccount: Boolean = false,
	onDone: (String, String) -> Unit = { email, password -> }

) {
	val focusManager = LocalFocusManager.current
	val email = rememberSaveable { mutableStateOf("") }
	val password = rememberSaveable { mutableStateOf("") }
	val passwordVisibility = rememberSaveable { mutableStateOf(false) }
	val passwordFocusRequest = FocusRequester.Default
	val keyboardController = LocalSoftwareKeyboardController.current
	val valid = remember(email.value, password.value) {
		email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
	}
	val modifier = Modifier
		.height(240.dp)
		.background(MaterialTheme.colors.background)
		.verticalScroll(rememberScrollState())

	Column(
		modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		if (isCreateAccount) Text(
			text = stringResource(R.string.create_account),
			modifier = Modifier.padding(4.dp)
		) else Text("")
		EmailInput(
			emailState = email,
			enabled = !loading,
			onAction = KeyboardActions {
				passwordFocusRequest.requestFocus()
			},
		)
		PasswordInput(
			modifier = Modifier.focusRequester(passwordFocusRequest),
			passwordState = password,
			labelId = "Password",
			enabled = !loading, //Todo change this
			passwordVisibility = passwordVisibility,
			onAction = KeyboardActions {
				if (!valid) return@KeyboardActions

				onDone(email.value.trim(), password.value.trim())
				keyboardController?.hide()

			})

		SubmitButton(
			textId = if (isCreateAccount) "CreteAccount" else "Login",
			loading = loading,
			validInputs = valid,
		) {
			onDone(email.value.trim(), password.value.trim())
			keyboardController?.hide()

		}


	}
}










