package com.applecompose.thebook.presentation.navigation.screen

sealed class Screen(val route: String) {

	object DetailsScreen: Screen("details_screen")
	object HomeScreen: Screen("home_screen")
	object SearchScreen: Screen("search_screen")
	object SplashScreen: Screen("splash_screen")
	object LoginScreen: Screen("login_screen")
	object SignupScreen: Screen("signup_screen")
	object StatsScreen: Screen("stats_screen")
	object UpdateScreen: Screen("update_screen")




}
