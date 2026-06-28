package ucne.edu.consumirapiplanets.data.remote.dto.planet

import com.squareup.moshi.Json

data class PlanetResponseDto(
    @Json(name = "items") val items: List<PlanetDto>
)