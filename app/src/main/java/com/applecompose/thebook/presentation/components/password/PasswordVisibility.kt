package com.applecompose.thebook.presentation.components.password

import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun PasswordVisibility(passwordVisibility: MutableState<Boolean>) {
	val visible = passwordVisibility.value
	IconButton(onClick = { passwordVisibility.value = !visible }) {
		Icons.Default.Close

	}

}
