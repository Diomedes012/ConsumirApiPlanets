package ucne.edu.consumirapiplanets.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ucne.edu.consumirapiplanets.presentation.detail.PlanetDetailScreen
import ucne.edu.consumirapiplanets.presentation.list.PlanetListScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.PlanetList.route,
        modifier = modifier
    ) {

        composable(route = Screen.PlanetList.route) {
            PlanetListScreen(
                onPlanetClick = { planetId ->
                    navController.navigate(Screen.PlanetDetail.createRoute(planetId))
                }
            )
        }

        composable(
            route = Screen.PlanetDetail.route,
            arguments = listOf(
                navArgument("planetId") {
                    type = NavType.StringType
                }
            )
        ) {
            PlanetDetailScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}