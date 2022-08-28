package com.applecompose.thebook.presentation.screens.login

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
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
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.applecompose.thebook.R
import com.applecompose.thebook.presentation.components.BookLogo
import com.applecompose.thebook.presentation.components.emails.EmailInput
import com.applecompose.thebook.presentation.components.password.PasswordInput

@Composable
fun LoginScreen(navController: NavController) {
	Surface(
		modifier = Modifier
			.fillMaxSize()
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Top
		) {
			BookLogo()
			UserForm(loading = false, isCreateAccount = false) { email, password ->
				Log.d("FORM", "LoginScreen: $email $password")
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
		.height(250.dp)
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

@Composable
fun SubmitButton(
	textId: String,
	loading: Boolean,
	validInputs: Boolean,
	onClick: () -> Unit
) {
	Button(
		onClick = onClick,
		modifier = Modifier
			.fillMaxWidth(),
		enabled = !loading && validInputs,
		shape = CircleShape,
	) {
		if (loading) CircularProgressIndicator(modifier = Modifier.size(24.dp))
		else Text(text = textId, modifier = Modifier.padding(6.dp))
	}


}










