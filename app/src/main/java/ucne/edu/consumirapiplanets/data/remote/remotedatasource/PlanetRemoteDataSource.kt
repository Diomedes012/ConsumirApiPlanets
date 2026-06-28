package ucne.edu.consumirapiplanets.data.remote.remotedatasource

import coil.network.HttpException
import ucne.edu.consumirapiplanets.data.remote.DragonBallApi
import ucne.edu.consumirapiplanets.data.remote.dto.planet.PlanetDto
import ucne.edu.consumirapiplanets.data.remote.dto.planet.PlanetResponseDto
import javax.inject.Inject

class PlanetRemoteDataSource @Inject constructor(
    private val api: DragonBallApi
) {
    suspend fun getPlanets(
        page: Int,
        limit: Int,
        name: String?,
        isDestroyed: Boolean?
    ): Result<PlanetResponseDto> {
        return try {
            val response = api.getPlanets(page, limit, name, isDestroyed)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error de servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun getPlanetsByName(name: String): Result<List<PlanetDto>> {
        return try {
            val response = api.getPlanetsByName(name)
            if (response.isSuccessful) Result.success(response.body()!!)
            else Result.failure(Exception("Error de red ${response.code()}"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getPlanetDetail(id: Int): Result<PlanetDto> {
        return try {
            val response = api.getPlanetDetail(id)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error de servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }
}