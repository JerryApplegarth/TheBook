package com.applecompose.thebook.presentation.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
			.fillMaxWidth()
			.padding(start = 16.dp, end = 16.dp),
		enabled = !loading && validInputs,
		shape = CircleShape,
	) {
		if (loading) CircularProgressIndicator(modifier = Modifier.size(24.dp))
		else Text(text = textId, modifier = Modifier.padding(6.dp))
	}


}

