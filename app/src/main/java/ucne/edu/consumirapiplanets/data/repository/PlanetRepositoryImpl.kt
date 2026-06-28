package ucne.edu.consumirapiplanets.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ucne.edu.consumirapiplanets.data.remote.Resource
import ucne.edu.consumirapiplanets.data.remote.remotedatasource.PlanetRemoteDataSource
import ucne.edu.consumirapiplanets.domain.repository.PlanetRepository
import ucne.edu.consumirapiplanets.domain.model.Planet
import javax.inject.Inject

class PlanetRepositoryImpl @Inject constructor(
    private val remoteDataSource: PlanetRemoteDataSource
): PlanetRepository {

    override fun getPlanets(
        page: Int,
        limit: Int,
        name: String?,
        isDestroyed: Boolean?
    ): Flow<Resource<List<Planet>>> = flow {
        emit(Resource.Loading())
        val response = remoteDataSource.getPlanets(page, limit, name, isDestroyed)
        response.onSuccess { planetResponse ->
            emit(Resource.Success(planetResponse.items.map { it.toDomain() }))
        }.onFailure {
            emit(Resource.Error(it.message ?: "Error desconocido"))
        }
    }

    override fun getPlanetsByName(name: String): Flow<Resource<List<Planet>>> = flow {
        emit(Resource.Loading())
        remoteDataSource.getPlanetsByName(name).onSuccess { dtoList ->
            emit(Resource.Success(dtoList.map { it.toDomain() }))
        }.onFailure { emit(Resource.Error(it.message ?: "Error desconocido")) }
    }


    override fun getPlanetDetail(id: Int): Flow<Resource<Planet>> = flow {
        emit(Resource.Loading())
        val response = remoteDataSource.getPlanetDetail(id)
        response.onSuccess { planetDto ->
            emit(Resource.Success(planetDto.toDomain()))
        }.onFailure {
            emit(Resource.Error(it.message ?: "Error desconocido"))
        }
    }
}