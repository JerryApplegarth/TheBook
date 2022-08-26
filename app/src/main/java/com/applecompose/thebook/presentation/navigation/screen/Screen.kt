package com.applecompose.thebook.presentation.navigation.screen

sealed class Screen(val route: String) {

	object DetailsScreen: Screen("details_screen")
	object HomeScreen: Screen("home_screen")
	object SearchScreen: Screen("search_screen")
	object SplashScreen: Screen("splash_screen")




}
