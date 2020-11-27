package com.game.rpg.mapper;

import com.game.rpg.domain.Character;
import com.game.rpg.dto.CharacterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = WeaponMapper.class)
public interface CharacterMapper {
    @Mapping(target = "about", source = "entity.story")
    CharacterDto mapToDto(Character entity);

    @Mapping(target = "story", source = "dto.about")
    Character mapToEntity(CharacterDto dto);
}
