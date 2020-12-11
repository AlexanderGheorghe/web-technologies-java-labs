package com.game.rpg.mapper;

import com.game.rpg.domain.Character;
import com.game.rpg.dto.CharacterDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-11T16:23:44+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9 (JetBrains s.r.o.)"
)
public class CharacterMapperImpl implements CharacterMapper {

    @Override
    public CharacterDto mapToDto(Character entity) {
        if ( entity == null ) {
            return null;
        }

        CharacterDto characterDto = new CharacterDto();

        characterDto.setAbout( entity.getStory() );
        characterDto.setId( entity.getId() );
        characterDto.setName( entity.getName() );
        characterDto.setWeapon( entity.getWeapon() );
        characterDto.setType( entity.getType() );
        characterDto.setLevel( entity.getLevel() );

        return characterDto;
    }

    @Override
    public Character mapToEntity(CharacterDto dto) {
        if ( dto == null ) {
            return null;
        }

        Character character = new Character();

        character.setStory( dto.getAbout() );
        character.setId( dto.getId() );
        character.setName( dto.getName() );
        character.setWeapon( dto.getWeapon() );
        character.setType( dto.getType() );
        character.setLevel( dto.getLevel() );

        return character;
    }
}
