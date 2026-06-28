package ucne.edu.consumirapiplanets.domain.usecase

import kotlinx.coroutines.flow.Flow
import ucne.edu.consumirapiplanets.data.remote.Resource
import ucne.edu.consumirapiplanets.domain.repository.CharacterRepository
import ucne.edu.consumirapiplanets.domain.model.Character
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(name: String? = null): Flow<Resource<List<Character>>> {
        return if (name.isNullOrBlank()) {
            repository.getCharacters()
        } else {
            repository.getCharactersByName(name)
        }
    }
}