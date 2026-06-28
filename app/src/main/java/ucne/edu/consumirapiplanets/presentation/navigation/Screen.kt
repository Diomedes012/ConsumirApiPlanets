package ucne.edu.consumirapiplanets.presentation.navigation

sealed class Screen(val route: String) {
    object PlanetList : Screen("planet_list")

    object PlanetDetail : Screen("planet_detail/{planetId}") {
        fun createRoute(planetId: Int): String {
            return "planet_detail/$planetId"
        }
    }

    object CharacterList : Screen("character_list")
    object CharacterDetail : Screen("character_detail/{characterId}") {
        fun createRoute(characterId: Int) = "character_detail/$characterId"
    }
}

