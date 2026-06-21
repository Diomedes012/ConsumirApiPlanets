package ucne.edu.consumirapiplanets.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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
}