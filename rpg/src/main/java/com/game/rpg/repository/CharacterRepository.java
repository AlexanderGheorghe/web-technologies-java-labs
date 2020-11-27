package com.game.rpg.repository;

import com.game.rpg.domain.Character;
import com.game.rpg.domain.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepository {

    private final List<Character> characterList = new ArrayList<>();
    private final WeaponRepository weaponRepository;

    @Autowired
    public CharacterRepository(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
        initCharacterList();
    }

    public Optional<Character> get(Long id) {
        return characterList.stream().filter(character -> character.getId().equals(id)).findFirst();
    }

    public List<Character> getAll() {
        return characterList;
    }

    private void addWeaponIfMissing(Weapon weapon) {
        if(!weaponRepository.weaponExists(weapon))
            weaponRepository.save(weapon);
    }

    public Character save(Character character) {
        addWeaponIfMissing(character.getWeapon());
        characterList.add(character);
        return character;
    }

    public String delete(Long id) {
        Optional<Character> characterOptional = get(id);
        if (characterOptional.isPresent()) {
            characterList.remove(characterOptional.get());
            return "Removed!";
        }
        return "Character not found!";

    }

    public Character update(Character character) {
        Optional<Character> characterOptional = get(character.getId());
        if (characterOptional.isPresent()) {
            characterList.remove(characterOptional.get());
            addWeaponIfMissing(character.getWeapon());
            characterList.add(character);
            return get(character.getId()).get();
        }
        return null;
    }

    private void initCharacterList() {
        characterList.add(Character.builder()
                .id(1L)
                .name("Wulfgar the Cruel")
                .weapon(weaponRepository.get(1L).get())
                .level(57)
                .type("Orc")
                .story("Wulfgar smash!")
                .build());

        characterList.add(Character.builder()
                .id(2L)
                .name("Pontius the wise")
                .weapon(weaponRepository.get(2L).get())
                .level(77)
                .type("Owl")
                .story("Whoo?")
                .build());
        characterList.add(Character.builder()
                .id(3L)
                .name("Amorphous blob")
                .weapon(weaponRepository.get(3L).get())
                .level(96)
                .type("Monster")
                .story("The thing that ate Cincinnati, Cleveland, or whatever.")
                .build());
    }
}
