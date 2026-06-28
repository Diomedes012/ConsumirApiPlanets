package ucne.edu.consumirapiplanets.data.remote.dto.character

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ucne.edu.consumirapiplanets.domain.model.Character

@JsonClass(generateAdapter = true)
data class CharacterDto(
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String
) {
    fun toDomain() = Character(
        id = id,
        name = name,
        ki = ki,
        maxKi = maxKi,
        race = race,
        gender = gender,
        description = description,
        image = image
    )
}