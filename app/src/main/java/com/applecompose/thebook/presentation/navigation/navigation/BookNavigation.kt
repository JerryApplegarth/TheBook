package com.applecompose.thebook.presentation.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.applecompose.thebook.presentation.navigation.screen.Screen
import com.applecompose.thebook.presentation.screens.detailsscreen.DetailsScreen
import com.applecompose.thebook.presentation.screens.homescreen.HomeScreen
import com.applecompose.thebook.presentation.screens.searchscreen.SearchScreen
import com.applecompose.thebook.presentation.screens.splashscreen.SplashScreen

@Composable
fun Navigation() {
	val navController = rememberNavController()
	NavHost(
		navController = navController,
		startDestination = Screen.SplashScreen.route) {

		composable(Screen.SplashScreen.route) {
			SplashScreen(navController = navController)
		}
		composable(Screen.HomeScreen.route) {
			HomeScreen(navController = navController)
		}
		composable(Screen.DetailsScreen.route) {
			DetailsScreen(navController = navController)
		}
		composable(Screen.SearchScreen.route) {
			SearchScreen(navController = navController)
		}
	}
}