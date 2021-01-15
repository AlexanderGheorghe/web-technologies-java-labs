package com.alexandru.videogamedistribution.validation.validators;

import com.alexandru.videogamedistribution.dto.UserDto;
import com.alexandru.videogamedistribution.validation.constraints.PasswordsMatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, UserDto> {

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context){
        return userDto.getPassword().equals(userDto.getMatchingPassword());
    }
}
