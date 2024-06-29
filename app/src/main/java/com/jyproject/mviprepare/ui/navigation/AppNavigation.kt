package com.jyproject.mviprepare.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jyproject.mviprepare.ui.feature.first.FirstScreen
import com.jyproject.mviprepare.ui.feature.second.SecondScreen
import com.jyproject.mviprepare.ui.navigation.Navigation.Args.NUM

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.Routes.FIRST
    ) {
        composable(
            route = Navigation.Routes.FIRST
        ) {
            FirstScreenDestination(navController = navController)
        }

        composable(
            route = Navigation.Routes.SECOND,
            arguments = listOf(navArgument(name = NUM){
                type = NavType.StringType
            })
        ){ navBackStackEntry ->
            val num = requireNotNull(navBackStackEntry.arguments?.getString(NUM)){ "Require number" }
            SecondScreen(
                number = num
            )
        }
    }
}

object Navigation {
    object Args {
        const val NUM = "number"
    }

    object Routes {
        const val FIRST = "first"
        const val SECOND = "${FIRST}/{$NUM}"
    }
}

fun NavController.navigateToSecond(number: String) {
    navigate(route = "${Navigation.Routes.FIRST}/$number")
}