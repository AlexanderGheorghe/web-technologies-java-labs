package com.game.rpg.repository;

import com.game.rpg.domain.Character;
import com.game.rpg.domain.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Character save(Character character) {
        String sql = "INSERT INTO characters VALUES(NULL, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, character.getName(), character.getWeapon(), character.getType(), character.getLevel(), character.getStory());
        return character;
    }

    public Optional<Character> get(Long id) {
        String sql = "SELECT * FROM characters WHERE id = ?";
        RowMapper<Character> mapper = getCharacterRowMapper();
        return jdbcTemplate.query(sql, mapper, id).stream().findAny();
    }

    public List<Character> getAll() {
        String sql = "SELECT * FROM characters";
        RowMapper<Character> mapper = getCharacterRowMapper();
        return jdbcTemplate.query(sql, mapper);
    }

    public Character update(Character character) {
        String sql = "UPDATE characters SET name = ?, weapon = ?, type = ?, level = ?, story = ? WHERE id = ?";
        jdbcTemplate.update(sql, character.getName(), character.getWeapon(), character.getType(), character.getLevel(), character.getStory());
        return get(character.getId()).get();
    }

    public String delete(Long id) {
        String sql = "DELETE FROM characters WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return "";
    }

    private RowMapper<Character> getCharacterRowMapper() {
        return (resultSet, i) -> new Character(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                (Weapon) resultSet.getObject("weapon"),
                resultSet.getString("type"),
                resultSet.getInt("level"),
                resultSet.getString("story")
        );
    }
}
