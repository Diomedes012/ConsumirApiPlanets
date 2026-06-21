package ucne.edu.consumirapiplanets.data.remote

import com.squareup.moshi.Json
import ucne.edu.consumirapiplanets.domain.model.Planet

data class PlanetDto(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "isDestroyed") val isDestroyed: Boolean,
    @Json(name = "description") val description: String,
    @Json(name = "image") val image: String
){
    fun toDomain() = Planet(
        id = id,
        name = name,
        isDestroyed = isDestroyed,
        description = description,
        image = image
    )
}
