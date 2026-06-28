package ucne.edu.consumirapiplanets.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ucne.edu.consumirapiplanets.data.remote.dto.character.CharacterDto
import ucne.edu.consumirapiplanets.data.remote.dto.character.CharacterResponseDto
import ucne.edu.consumirapiplanets.data.remote.dto.planet.PlanetDto
import ucne.edu.consumirapiplanets.data.remote.dto.planet.PlanetResponseDto

interface DragonBallApi {
    @GET("planets")
    suspend fun getPlanets(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10,
        @Query("name") name: String? = null,
        @Query("isDestroyed") isDestroyed: Boolean? = null
    ): Response<PlanetResponseDto>

    @GET("planets")
    suspend fun getPlanetsByName(
        @Query("name") name: String
    ): Response<List<PlanetDto>>

    @GET("planets/{id}")
    suspend fun getPlanetDetail(
        @Path("id") id: Int
    ): Response<PlanetDto>

    @GET("characters")
    suspend fun getCharacters(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10
    ): Response<CharacterResponseDto>

    @GET("characters")
    suspend fun filterCharacters(
        @Query("name") name: String? = null,
        @Query("gender") gender: String? = null,
        @Query("race") race: String? = null
    ): Response<List<CharacterDto>>

    @GET("characters/{id}")
    suspend fun getCharacterDetail(
        @Path("id") id: Int
    ): Response<CharacterDto>
}