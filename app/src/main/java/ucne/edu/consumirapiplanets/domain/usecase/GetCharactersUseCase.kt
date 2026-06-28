package ucne.edu.consumirapiplanets.domain.usecase

import kotlinx.coroutines.flow.Flow
import ucne.edu.consumirapiplanets.data.remote.Resource
import ucne.edu.consumirapiplanets.domain.repository.CharacterRepository
import ucne.edu.consumirapiplanets.domain.model.Character
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(
        name: String? = null,
        gender: String? = null,
        race: String? = null
    ): Flow<Resource<List<Character>>> {

        val hasNoFilters = name.isNullOrBlank() && gender.isNullOrBlank() && race.isNullOrBlank()

        return if (hasNoFilters) {
            repository.getCharacters()
        } else {
            repository.filterCharacters(
                name = name.takeIf { !it.isNullOrBlank() },
                gender = gender.takeIf { !it.isNullOrBlank() },
                race = race.takeIf { !it.isNullOrBlank() }
            )
        }
    }
}