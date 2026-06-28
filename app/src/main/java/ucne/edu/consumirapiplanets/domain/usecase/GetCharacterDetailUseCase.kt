package ucne.edu.consumirapiplanets.domain.usecase

import kotlinx.coroutines.flow.Flow
import ucne.edu.consumirapiplanets.data.remote.Resource
import ucne.edu.consumirapiplanets.domain.repository.CharacterRepository
import ucne.edu.consumirapiplanets.domain.model.Character
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(id: Int): Flow<Resource<Character>> {
        return repository.getCharacterDetail(id)
    }
}