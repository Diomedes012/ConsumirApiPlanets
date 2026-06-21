package ucne.edu.consumirapiplanets.presentation.detail

import ucne.edu.consumirapiplanets.domain.model.Planet

data class PlanetDetailUiState(
    val isLoading: Boolean = false,
    val planet: Planet? = null,
    val error: String? = null
)
