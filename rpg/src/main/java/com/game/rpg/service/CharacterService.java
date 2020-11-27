package com.game.rpg.service;

import com.game.rpg.repository.CharacterRepository;
import com.game.rpg.domain.Character;
import com.game.rpg.dto.CharacterDto;
import com.game.rpg.mapper.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, CharacterMapper characterMapper) {
        this.characterRepository = characterRepository;
        this.characterMapper = characterMapper;
    }

    public CharacterDto get(Long id) {
        return characterMapper.mapToDto(characterRepository.get(id).get());
    }

    public List<CharacterDto> getAll() {
        return characterRepository.getAll().stream()
                .map(characterMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public CharacterDto create(CharacterDto request) {
        Character savedCharacter = characterRepository.save(characterMapper.mapToEntity(request));
        return characterMapper.mapToDto(savedCharacter);
    }

    public CharacterDto update(CharacterDto request) {
        Character updatedCharacter = characterRepository.update(characterMapper.mapToEntity(request));
        if (updatedCharacter != null) {
            return characterMapper.mapToDto(updatedCharacter);
        }
        return null;
    }

    public String delete(Long id) {
        return characterRepository.delete(id);
    }

}
