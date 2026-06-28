package ucne.edu.consumirapiplanets.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Public
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(val route: String, val title: String, val icon: ImageVector) {
    object Planetas : NavigationItem(Screen.PlanetList.route, "Planetas", Icons.Default.Public)
    object Personajes : NavigationItem(Screen.CharacterList.route, "Personajes", Icons.Default.Person)
}