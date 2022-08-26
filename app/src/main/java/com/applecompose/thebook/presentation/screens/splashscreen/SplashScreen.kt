package com.applecompose.thebook.presentation.screens.splashscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SplashScreen(navController: NavController) {
	Surface(modifier = Modifier
		.padding(16.dp)
		.size(330.dp),
		shape = CircleShape,
		color = Color.White,
		border = BorderStroke(
			2.dp,
			color = Color.LightGray),

	) {
		Column(
			modifier = Modifier
				.padding(1.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {
			Text(
				text = "The Book",
				style = MaterialTheme.typography.h3,
				color = MaterialTheme.colors.primary.copy(alpha = 0.7f)
				)
			Spacer(modifier = Modifier.height(16.dp))
			Text(
				text = "\"Read Something Today\"",
				style = MaterialTheme.typography.h5,
				color = MaterialTheme.colors.primaryVariant

				)



		}

	}


}