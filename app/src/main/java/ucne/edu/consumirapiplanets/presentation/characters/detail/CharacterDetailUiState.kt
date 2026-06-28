package ucne.edu.consumirapiplanets.presentation.characters.detail
import ucne.edu.consumirapiplanets.domain.model.Character

data class CharacterDetailUiState(
    val isLoading: Boolean = false,
    val character: Character? = null,
    val error: String? = null
)