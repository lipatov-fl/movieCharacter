package com.example.moviecharacter.presentation.state

import com.example.moviecharacter.domain.model.Characters

data class CharactersState(
    val characters: List<Characters>? = emptyList(),
    val errorMsg: String? = "",
    val isLoading: Boolean = false
)