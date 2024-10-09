package com.example.moviecharacter.data.api

import com.example.moviecharacter.data.dto.CharactersDto
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getAllCharacters(): List<CharactersDto>
}