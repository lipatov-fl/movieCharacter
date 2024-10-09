package com.example.moviecharacter.di

import com.example.moviecharacter.core.utils.Constants.BASE_URL
import com.example.moviecharacter.data.api.CharacterApi
import com.example.moviecharacter.data.repository.CharactersRepositoryImpl
import com.example.moviecharacter.domain.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideCharactersApi(retrofit: Retrofit): CharacterApi =
        retrofit.create(CharacterApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: CharacterApi): CharactersRepository {
        return CharactersRepositoryImpl(api)
    }
}