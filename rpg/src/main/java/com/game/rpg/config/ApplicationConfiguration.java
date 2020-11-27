package com.game.rpg.config;

import com.game.rpg.mapper.CharacterMapper;
import com.game.rpg.mapper.CharacterMapperImpl;
import com.game.rpg.mapper.WeaponMapper;
import com.game.rpg.mapper.WeaponMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public CharacterMapper characterMapper() { return new CharacterMapperImpl(); }
    @Bean
    public WeaponMapper weaponMapper() { return new WeaponMapperImpl(); }
}
