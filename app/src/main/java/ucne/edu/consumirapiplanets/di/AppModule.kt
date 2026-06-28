package ucne.edu.consumirapiplanets.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ucne.edu.consumirapiplanets.data.remote.DragonBallApi
import ucne.edu.consumirapiplanets.data.remote.remotedatasource.CharacterRemoteDataSource
import ucne.edu.consumirapiplanets.data.remote.remotedatasource.PlanetRemoteDataSource
import ucne.edu.consumirapiplanets.data.repository.CharacterRepositoryImpl
import ucne.edu.consumirapiplanets.data.repository.PlanetRepositoryImpl
import ucne.edu.consumirapiplanets.domain.repository.CharacterRepository
import ucne.edu.consumirapiplanets.domain.repository.PlanetRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(moshi: Moshi): DragonBallApi {
        return Retrofit.Builder()
            .baseUrl("https://dragonball-api.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(DragonBallApi::class.java)
    }

    @Provides
    @Singleton
    fun providePlanetRepository(api: DragonBallApi): PlanetRepository {
        return PlanetRepositoryImpl(PlanetRemoteDataSource(api))
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: DragonBallApi): CharacterRepository {
        return CharacterRepositoryImpl(CharacterRemoteDataSource(api))
    }
}