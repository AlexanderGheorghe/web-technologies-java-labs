package com.game.rpg.dto;

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
public class WeaponDto {

    @NotNull
    private Long id;
    @Size(min = 3, max = 30)
    private String name;
    private String type;
    private Integer damage;
    private String details;

}
