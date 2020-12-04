package com.game.rpg.domain;

import com.game.rpg.validators.RequiredIf;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@RequiredIf(message = "Weapon name can not be empty.")
public class Character {

    @NotNull
    private Long id;
    @Size(min = 3, max = 30)
    private String name;
    private Weapon weapon;
    private String type;
    private Integer level;
    private String story;

}
