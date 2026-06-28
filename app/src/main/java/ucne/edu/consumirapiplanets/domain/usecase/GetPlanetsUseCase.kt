package ucne.edu.consumirapiplanets.domain.usecase

import kotlinx.coroutines.flow.Flow
import ucne.edu.consumirapiplanets.data.remote.Resource
import ucne.edu.consumirapiplanets.domain.repository.PlanetRepository
import ucne.edu.consumirapiplanets.domain.model.Planet
import javax.inject.Inject

class GetPlanetsUseCase @Inject constructor(
    private val repository: PlanetRepository
) {
    operator fun invoke(name: String? = null): Flow<Resource<List<Planet>>> {
        return if (name.isNullOrBlank()) {
            repository.getPlanets()
        } else {
            repository.getPlanetsByName(name)
        }
    }
}