package com.game.rpg.repository;

import com.game.rpg.domain.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WeaponRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Weapon save(Weapon weapon) {
        String sql = "INSERT INTO weapons VALUES(NULL, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, weapon.getName(), weapon.getName(), weapon.getDamage(), weapon.getDetails());
        return weapon;
    }

    public Optional<Weapon> get(Long id) {
        String sql = "SELECT * FROM weapons WHERE id = ?";
        RowMapper<Weapon> mapper = getWeaponRowMapper();
        return jdbcTemplate.query(sql, mapper, id).stream().findAny();
    }

    public List<Weapon> getAll() {
        String sql = "SELECT * FROM weapons";
        RowMapper<Weapon> mapper = getWeaponRowMapper();
        return jdbcTemplate.query(sql, mapper);
    }

    public Weapon update(Weapon weapon) {
        String sql = "UPDATE weapons SET name = ?, type = ?, damage = ?, details = ? WHERE id = ?";
        jdbcTemplate.update(sql, weapon.getName(), weapon.getType(), weapon.getDamage(), weapon.getDetails());
        return get(weapon.getId()).get();
    }

    public String delete(Long id) {
        String sql = "DELETE FROM weapons WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return "";
    }

    private RowMapper<Weapon> getWeaponRowMapper() {
        return (resultSet, i) -> new Weapon(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("type"),
                resultSet.getInt("damage"),
                resultSet.getString("details")
        );
    }

    public boolean weaponExists(Weapon weapon){
        return get(weapon.getId()).isPresent();
    }
}
