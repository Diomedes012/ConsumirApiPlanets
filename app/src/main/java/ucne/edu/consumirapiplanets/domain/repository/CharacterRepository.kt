package ucne.edu.consumirapiplanets.domain.repository

import kotlinx.coroutines.flow.Flow
import ucne.edu.consumirapiplanets.data.remote.Resource
import ucne.edu.consumirapiplanets.domain.model.Character

interface CharacterRepository {
    fun getCharacters(page: Int = 1, limit: Int = 10): Flow<Resource<List<Character>>>
    fun filterCharactersByName(name: String): Flow<Resource<List<Character>>>
    fun getCharacterDetail(id: Int): Flow<Resource<Character>>
}