package com.game.rpg.domain;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Weapon {

    @NotNull
    private Long id;
    @Size(min = 3, max = 30)
    private String name;
    private String type;
    private Integer damage;
    private String details;

}
