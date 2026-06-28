package ucne.edu.consumirapiplanets.presentation.characters.list

sealed interface CharacterListEvent {
    data class UpdateName(val name: String) : CharacterListEvent
    data class UpdateGender(val gender: String) : CharacterListEvent
    data class UpdateRace(val race: String) : CharacterListEvent
    object Search : CharacterListEvent
}