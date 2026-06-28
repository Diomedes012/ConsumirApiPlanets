package ucne.edu.consumirapiplanets.presentation.characters.list

sealed interface CharacterListEvent {
    data class UpdateName(val name: String) : CharacterListEvent
    object Search : CharacterListEvent
}