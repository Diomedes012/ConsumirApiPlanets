package ucne.edu.consumirapiplanets.presentation.planets.list

import ucne.edu.consumirapiplanets.domain.model.Planet

data class PlanetListUiState(
    val isLoading: Boolean = false,
    val planets: List<Planet> = emptyList(),
    val error: String? = null,
    val filterName: String = "",
    val filterIsDestroyed: String = ""
)
