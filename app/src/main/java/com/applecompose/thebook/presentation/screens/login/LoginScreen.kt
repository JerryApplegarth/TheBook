package com.applecompose.thebook.presentation.screens.login

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.applecompose.thebook.presentation.components.BookLogo

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

		}

	}


}
@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun UserForm() {
	val email = rememberSaveable { mutableStateOf("") }
	val password = rememberSaveable { mutableStateOf("")}
	val passwordVisibility = rememberSaveable { mutableStateOf(false) 	}
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


	}

}

@Composable
fun EmailInput(
	modifier: Modifier = Modifier,
	emailState: MutableState<String>,
	labelId: String = "Email",
	enabled: Boolean = true,
	imeAction: ImeAction = ImeAction.Next,
	onAction: KeyboardActions = KeyboardActions.Default,

) {
	InputField()

}

@Composable
fun InputField(
	modifier: Modifier = Modifier,
	valueState: MutableState<String>,
	labelId: String,
	enabled: Boolean,
	isSingleLine: Boolean = true,
	keyboardType: KeyboardType = KeyboardType.Text,
	imeAction: ImeAction = ImeAction.Next,
	onAction: KeyboardActions = KeyboardActions.Default
) {


}


