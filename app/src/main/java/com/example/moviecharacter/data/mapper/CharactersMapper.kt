package com.example.moviecharacter.data.mapper

import com.example.moviecharacter.data.dto.CharactersDto
import com.example.moviecharacter.domain.model.Characters

fun CharactersDto.toDomainCharacter(): Characters {
    return Characters(actor, id, image, name)
}