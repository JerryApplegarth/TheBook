package com.applecompose.thebook.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BookLogo(modifier: Modifier = Modifier) {
	Text(
		modifier = Modifier.padding(bottom = 16.dp),
		text = "The Book",
		style = MaterialTheme.typography.h3,
		color = MaterialTheme.colors.primary.copy(alpha = 0.7f)
	)
}
