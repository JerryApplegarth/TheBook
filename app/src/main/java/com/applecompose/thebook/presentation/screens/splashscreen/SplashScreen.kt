package com.applecompose.thebook.presentation.screens.splashscreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.applecompose.thebook.presentation.navigation.screen.Screen
import kotlinx.coroutines.delay
import com.applecompose.thebook.presentation.components.BookLogo

@Composable
fun SplashScreen(navController: NavController) {
	val scale = remember {
		Animatable(0f)
	}
	LaunchedEffect(key1 = true) {
		scale.animateTo(targetValue = 0.9f,
		animationSpec = tween(800,
		easing = {
			OvershootInterpolator(8f)
				.getInterpolation(it)
		}))
		delay(2000L)
		navController.navigate(Screen.LoginScreen.route)
	}
	Surface(modifier = Modifier
		.padding(16.dp)
		.size(330.dp)
		.scale(scale.value),
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
			BookLogo()
			Spacer(modifier = Modifier.height(16.dp))
			Text(
				text = "\"Read Something Today\"",
				style = MaterialTheme.typography.h5,
				color = MaterialTheme.colors.primaryVariant
				)
		}
	}
}

