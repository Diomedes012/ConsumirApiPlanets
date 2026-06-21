package ucne.edu.consumirapiplanets.domain.Repository

import kotlinx.coroutines.flow.Flow
import ucne.edu.consumirapiplanets.data.remote.Resource
import ucne.edu.consumirapiplanets.domain.model.Planet

interface PlanetRepository {
    fun getPlanets(
        page: Int = 1,
        limit: Int = 10,
        name: String? = null,
        isDestroyed: Boolean? = null
    ): Flow<Resource<List<Planet>>>

    fun getPlanetsByName(name: String): Flow<Resource<List<Planet>>>

    fun getPlanetDetail(id: Int): Flow<Resource<Planet>>
}