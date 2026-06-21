package ucne.edu.consumirapiplanets.data.remote

import com.squareup.moshi.Json

data class PlanetResponseDto(
    @Json(name = "items") val items: List<PlanetDto>
)