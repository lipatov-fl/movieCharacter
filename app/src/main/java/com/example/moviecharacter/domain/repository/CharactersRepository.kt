package com.example.moviecharacter.domain.repository

import com.example.moviecharacter.core.common.Resource
import com.example.moviecharacter.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getAllCharacters(): Flow<Resource<List<Characters>>>
}