package com.game.rpg.repository;

import com.game.rpg.domain.Weapon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WeaponRepository {

    private final List<Weapon> weaponList = new ArrayList<>();

    public WeaponRepository() {
        initWeaponList();
    }

    public Optional<Weapon> get(Long id) {
        return weaponList.stream().filter(weapon -> weapon.getId().equals(id)).findFirst();
    }

    public List<Weapon> getAll() {
        return weaponList;
    }

    public Weapon save(Weapon weapon) {
        weaponList.add(weapon);
        return weapon;
    }

    public String delete(Long id) {
        Optional<Weapon> characterOptional = get(id);
        if (characterOptional.isPresent()) {
            weaponList.remove(characterOptional.get());
            return "Removed!";
        }
        return "Weapon not found!";
    }

    public Weapon update(Weapon weapon) {
        Optional<Weapon> weaponOptional = get(weapon.getId());
        if (weaponOptional.isPresent()) {
            weaponList.remove(weaponOptional.get());
            weaponList.add(weapon);
            return get(weapon.getId()).get();
        }
        return null;
    }

    private void initWeaponList() {
        weaponList.add(Weapon.builder()
                .id(1L)
                .name("Railgun of total annihilation")
                .damage(99)
                .type("Piercing")
                .details("Obliterates everything!")
                .build());

        weaponList.add(Weapon.builder()
                .id(2L)
                .name("Staff of healing")
                .damage(-25)
                .type("Magical")
                .details("Big heal.")
                .build());
        weaponList.add(Weapon.builder()
                .id(3L)
                .name("Wooden Sword")
                .damage(1)
                .type("Melee")
                .details("Not really a weapon.")
                .build());
    }

    public boolean weaponExists(Weapon weapon){
        for (var w : weaponList)
            if(w.equals(weapon))
                return true;
        return false;
    }
}
