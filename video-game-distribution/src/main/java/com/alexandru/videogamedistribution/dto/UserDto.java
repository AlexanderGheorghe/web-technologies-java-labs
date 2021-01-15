package com.alexandru.videogamedistribution.dto;

import com.alexandru.videogamedistribution.validation.constraints.PasswordsMatch;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@PasswordsMatch(message = "Password and confirmed password do not match. Please try again!")
public class UserDto {
    @NotBlank(message = "Please fill in the first name field.")
    private String firstName;

    @NotBlank(message = "Please fill in the last name field.")
    private String lastName;

    @Email(message = "Please enter a valid email.")
    private String email;

    @NotBlank(message = "Please set a password.")
    private String password;
    private String matchingPassword;
}
