package ucne.edu.consumirapiplanets.data.remote.remotedatasource

import ucne.edu.consumirapiplanets.data.remote.DragonBallApi
import ucne.edu.consumirapiplanets.data.remote.dto.character.CharacterDto
import ucne.edu.consumirapiplanets.data.remote.dto.character.CharacterResponseDto
import javax.inject.Inject

class CharacterRemoteDataSource @Inject constructor(
    private val api: DragonBallApi
) {
    suspend fun getCharacters(page: Int = 1, limit: Int = 10): Result<CharacterResponseDto> {
        return try {
            val response = api.getCharacters(page, limit)
            if (response.isSuccessful) Result.success(response.body()!!)
            else Result.failure(Exception("Error de red ${response.code()}"))
        } catch (e: Exception) { Result.failure(e) }
    }

    suspend fun filterCharacters(name: String?, gender: String?, race: String?): Result<List<CharacterDto>> {
        return try {
            val response = api.filterCharacters(name, gender, race)
            if (response.isSuccessful) Result.success(response.body()!!)
            else Result.failure(Exception("Error de red ${response.code()}"))
        } catch (e: Exception) { Result.failure(e) }
    }

    suspend fun getCharacterDetail(id: Int): Result<CharacterDto> {
        return try {
            val response = api.getCharacterDetail(id)
            if (response.isSuccessful) Result.success(response.body()!!)
            else Result.failure(Exception("Error de red ${response.code()}"))
        } catch (e: Exception) { Result.failure(e) }
    }
}