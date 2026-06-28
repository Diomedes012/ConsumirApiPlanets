package ucne.edu.consumirapiplanets.data.remote.dto.character

import com.squareup.moshi.Json
import ucne.edu.consumirapiplanets.domain.model.Character

data class CharacterResponseDto(
    @Json(name = "items") val items: List<CharacterDto>
)