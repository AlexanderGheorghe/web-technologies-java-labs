package com.game.rpg.mapper;

import com.game.rpg.domain.Weapon;
import com.game.rpg.dto.WeaponDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-11T16:23:44+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9 (JetBrains s.r.o.)"
)
public class WeaponMapperImpl implements WeaponMapper {

    @Override
    public WeaponDto mapToDto(Weapon entity) {
        if ( entity == null ) {
            return null;
        }

        WeaponDto weaponDto = new WeaponDto();

        weaponDto.setId( entity.getId() );
        weaponDto.setName( entity.getName() );
        weaponDto.setType( entity.getType() );
        weaponDto.setDamage( entity.getDamage() );
        weaponDto.setDetails( entity.getDetails() );

        return weaponDto;
    }

    @Override
    public Weapon mapToEntity(WeaponDto dto) {
        if ( dto == null ) {
            return null;
        }

        Weapon weapon = new Weapon();

        weapon.setId( dto.getId() );
        weapon.setName( dto.getName() );
        weapon.setType( dto.getType() );
        weapon.setDamage( dto.getDamage() );
        weapon.setDetails( dto.getDetails() );

        return weapon;
    }
}
