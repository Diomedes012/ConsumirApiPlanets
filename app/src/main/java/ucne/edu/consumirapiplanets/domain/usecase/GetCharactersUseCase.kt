package ucne.edu.consumirapiplanets.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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

        val apiFlow = if (name.isNullOrBlank()) {
            repository.getCharacters()
        } else {
            repository.filterCharactersByName(name)
        }

        return apiFlow.map { resource ->
            when (resource) {
                is Resource.Success -> {
                    var filteredList = resource.data ?: emptyList()

                    if (!gender.isNullOrBlank()) {
                        filteredList = filteredList.filter {
                            it.gender.equals(gender.trim(), ignoreCase = true)
                        }
                    }

                    if (!race.isNullOrBlank()) {
                        filteredList = filteredList.filter {
                            it.race.equals(race.trim(), ignoreCase = true)
                        }
                    }

                    Resource.Success(filteredList)
                }
                else -> resource
            }
        }
    }
}