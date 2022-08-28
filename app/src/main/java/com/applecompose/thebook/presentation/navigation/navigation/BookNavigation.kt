package com.applecompose.thebook.presentation.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.applecompose.thebook.presentation.navigation.screen.Screen
import com.applecompose.thebook.presentation.screens.detailsscreen.DetailsScreen
import com.applecompose.thebook.presentation.screens.homescreen.HomeScreen
import com.applecompose.thebook.presentation.screens.login.LoginScreen

import com.applecompose.thebook.presentation.screens.searchscreen.SearchScreen
import com.applecompose.thebook.presentation.screens.signup.SignupScreen
import com.applecompose.thebook.presentation.screens.splashscreen.SplashScreen
import com.applecompose.thebook.presentation.screens.stats.StatsScreen
import com.applecompose.thebook.presentation.screens.update.UpdateScreen

@OptIn(ExperimentalComposeUiApi::class)
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
		composable(Screen.LoginScreen.route) {
			LoginScreen(navController = navController)
		}
		composable(Screen.SignupScreen.route) {
			SignupScreen(navController = navController)
		}
		composable(Screen.StatsScreen.route) {
			StatsScreen(navController = navController)
		}
		composable(Screen.UpdateScreen.route) {
			UpdateScreen(navController = navController)
		}
	}
}