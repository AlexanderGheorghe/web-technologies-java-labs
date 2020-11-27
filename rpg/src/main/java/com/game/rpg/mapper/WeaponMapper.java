package com.game.rpg.mapper;

import com.game.rpg.domain.Weapon;
import com.game.rpg.dto.WeaponDto;
import org.mapstruct.Mapper;

@Mapper
public interface WeaponMapper {
    WeaponDto mapToDto(Weapon entity);
    Weapon mapToEntity(WeaponDto dto);
}
