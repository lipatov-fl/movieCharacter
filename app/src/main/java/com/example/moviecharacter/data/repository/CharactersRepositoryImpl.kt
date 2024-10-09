package com.example.moviecharacter.data.repository

import com.example.moviecharacter.core.common.Resource
import com.example.moviecharacter.data.api.CharacterApi
import com.example.moviecharacter.data.mapper.toDomainCharacter
import com.example.moviecharacter.domain.model.Characters
import com.example.moviecharacter.domain.repository.CharactersRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ViewModelScoped
class CharactersRepositoryImpl @Inject constructor(private val characterApi: CharacterApi) :
    CharactersRepository {
    override fun getAllCharacters(): Flow<Resource<List<Characters>>> = flow {
        emit(Resource.Loading())
        val result = characterApi.getAllCharacters().map {
            it.toDomainCharacter()
        }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.message.toString()))
    }
}