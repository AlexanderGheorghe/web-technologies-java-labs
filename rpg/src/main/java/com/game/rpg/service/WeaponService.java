package com.game.rpg.service;

import com.game.rpg.domain.Weapon;
import com.game.rpg.dto.WeaponDto;
import com.game.rpg.mapper.WeaponMapper;
import com.game.rpg.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;
    private final WeaponMapper weaponMapper;

    @Autowired
    public WeaponService(WeaponRepository weaponRepository, WeaponMapper weaponMapper) {
        this.weaponRepository = weaponRepository;
        this.weaponMapper = weaponMapper;
    }

    public WeaponDto get(Long id) {
        return weaponMapper.mapToDto(weaponRepository.get(id).get());
    }

    public List<WeaponDto> getAll() {
        return weaponRepository.getAll().stream()
                .map(weaponMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public WeaponDto create(WeaponDto request) {
        Weapon savedWeapon = weaponRepository.save(weaponMapper.mapToEntity(request));
        return weaponMapper.mapToDto(savedWeapon);
    }

    public WeaponDto update(WeaponDto request) {
        Weapon updatedWeapon = weaponRepository.update(weaponMapper.mapToEntity(request));
        if (updatedWeapon != null) {
            return weaponMapper.mapToDto(updatedWeapon);
        }
        return null;
    }

    public String delete(Long id) {
        return weaponRepository.delete(id);
    }

}
