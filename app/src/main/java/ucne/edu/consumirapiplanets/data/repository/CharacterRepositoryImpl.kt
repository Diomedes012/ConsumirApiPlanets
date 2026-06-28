package ucne.edu.consumirapiplanets.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ucne.edu.consumirapiplanets.data.remote.Resource
import ucne.edu.consumirapiplanets.data.remote.remotedatasource.CharacterRemoteDataSource
import ucne.edu.consumirapiplanets.domain.repository.CharacterRepository
import ucne.edu.consumirapiplanets.domain.model.Character
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource
): CharacterRepository {

    override fun getCharacters(page: Int, limit: Int): Flow<Resource<List<Character>>> = flow {
        emit(Resource.Loading())
        remoteDataSource.getCharacters(page, limit).onSuccess { response ->
            emit(Resource.Success(response.items.map { it.toDomain() }))
        }.onFailure { emit(Resource.Error(it.message ?: "Error desconocido")) }
    }

    override fun filterCharacters(name: String?, gender: String?, race: String?): Flow<Resource<List<Character>>> = flow {
        emit(Resource.Loading())
        remoteDataSource.filterCharacters(name, gender, race).onSuccess { dtoList ->
            emit(Resource.Success(dtoList.map { it.toDomain() }))
        }.onFailure { emit(Resource.Error(it.message ?: "Error desconocido")) }
    }

    override fun getCharacterDetail(id: Int): Flow<Resource<Character>> = flow {
        emit(Resource.Loading())
        remoteDataSource.getCharacterDetail(id).onSuccess { dto ->
            emit(Resource.Success(dto.toDomain()))
        }.onFailure { emit(Resource.Error(it.message ?: "Error desconocido")) }
    }
}