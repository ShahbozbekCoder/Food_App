package com.shahbozbek.foodapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("home_screen") {
            HomeScreen(navController = navController)
        }
        composable("product_details_screen") {
            ProductDetailsScreen(navController = navController)
        }
        composable("order_screen") {
            OrderScreen(navController = navController)
        }
        composable("payment_screen") {
            PaymentScreen(navController = navController)
        }
        composable("success_screen") {
            SuccessPopupMessage(navController = navController, onDismiss = {})
        }
        composable("profile_screen") {
            UserProfileScreen(navController = navController)
        }
        composable("custom_support_screen") {
            CustomerSupportUI(navController = navController)
        }
    }
}