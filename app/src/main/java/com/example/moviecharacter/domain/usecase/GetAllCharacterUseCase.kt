package com.example.moviecharacter.domain.usecase

import com.example.moviecharacter.domain.repository.CharactersRepository
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(private val charactersRepository: CharactersRepository) {
    operator fun invoke() = charactersRepository.getAllCharacters()
}