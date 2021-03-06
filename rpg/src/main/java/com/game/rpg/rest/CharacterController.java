package com.game.rpg.rest;

import com.game.rpg.exceptions.BadRequestException;
import com.game.rpg.exceptions.EntityNotFoundException;
import com.game.rpg.service.CharacterService;
import com.game.rpg.dto.CharacterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CharacterDto> getAll() {
        return characterService.getAll();
    }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterDto> create(@Valid @RequestBody CharacterDto character) {
        return new ResponseEntity<>(characterService.create(character), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterDto> update(@RequestBody CharacterDto character) {
        var updatedCharacter = characterService.update(character);
        if(updatedCharacter == null)
            throw new EntityNotFoundException("Cannot find character with id " + character.getId());
        return new ResponseEntity<>(updatedCharacter, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        if(id < 0)
            throw new BadRequestException("Character id can not be negative!");
        return characterService.delete(id);
    }
}
