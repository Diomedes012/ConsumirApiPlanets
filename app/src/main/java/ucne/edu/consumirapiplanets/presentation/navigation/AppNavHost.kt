package ucne.edu.consumirapiplanets.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ucne.edu.consumirapiplanets.presentation.characters.detail.CharacterDetailScreen
import ucne.edu.consumirapiplanets.presentation.characters.list.CharacterListScreen
import ucne.edu.consumirapiplanets.presentation.planets.detail.PlanetDetailScreen
import ucne.edu.consumirapiplanets.presentation.planets.list.PlanetListScreen

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
                navArgument("planetId") { type = NavType.StringType }
            )
        ) {
            PlanetDetailScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable(route = Screen.CharacterList.route) {
            CharacterListScreen(
                onCharacterClick = { characterId ->
                    navController.navigate(Screen.CharacterDetail.createRoute(characterId))
                }
            )
        }

        composable(
            route = Screen.CharacterDetail.route,
            arguments = listOf(
                navArgument("characterId") { type = NavType.StringType }
            )
        ) {
            CharacterDetailScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}