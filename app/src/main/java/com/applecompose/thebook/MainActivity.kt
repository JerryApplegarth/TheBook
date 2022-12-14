package com.applecompose.thebook

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.applecompose.thebook.presentation.navigation.navigation.Navigation
import com.applecompose.thebook.ui.theme.TheBookTheme
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			TheBookTheme {
				MainScreen()



			}
		}
	}
}

@Composable
fun MainScreen() {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colors.background,

	) {
		Column(
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Navigation()

		}


	}

}

