package ucne.edu.consumirapiplanets.domain.usecase

import ucne.edu.consumirapiplanets.domain.repository.PlanetRepository
import javax.inject.Inject

class GetPlanetDetailUseCase @Inject constructor(
    private val repository: PlanetRepository
) {
    operator fun invoke(id: Int) = repository.getPlanetDetail(id)
}