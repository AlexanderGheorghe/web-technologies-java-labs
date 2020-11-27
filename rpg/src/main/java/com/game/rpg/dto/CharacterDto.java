package com.game.rpg.dto;

import com.game.rpg.domain.Weapon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {

    @NotNull
    private Long id;
    @Size(min = 3, max = 30)
    private String name;
    private Weapon weapon;
    private String type;
    private Integer level;
    private String about;

}
