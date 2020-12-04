package com.game.rpg.validators;

import com.game.rpg.dto.CharacterDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredIfValidator implements ConstraintValidator<RequiredIf, CharacterDto> {

    @Override
    public boolean isValid(@org.jetbrains.annotations.NotNull CharacterDto character, ConstraintValidatorContext context) {
        if (character.getWeapon() != null) {
            return !character.getWeapon().getName().isEmpty();
        }
        return true;
    }
}
