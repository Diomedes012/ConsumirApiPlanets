package ucne.edu.consumirapiplanets.presentation.planets.list

sealed interface PlanetListEvent {
    data class UpdateName(val name: String) : PlanetListEvent
    object Search : PlanetListEvent
}