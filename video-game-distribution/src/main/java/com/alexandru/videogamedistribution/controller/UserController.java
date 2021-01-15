package com.alexandru.videogamedistribution.controller;

import com.alexandru.videogamedistribution.dto.UserDto;
import com.alexandru.videogamedistribution.entity.ConfirmationToken;
import com.alexandru.videogamedistribution.exception.UserAlreadyExistsException;
import com.alexandru.videogamedistribution.service.ConfirmationTokenService;
import com.alexandru.videogamedistribution.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/sign-up")
    public String showRegistrationForm(UserDto userDto) {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String registerUserAccount(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "sign-up";
        }
        try {
            userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("error", "There is already an account registered for " + userDto.getEmail());
            return "sign-up";
        }
        return "redirect:/login";
    }

    @GetMapping("/sign-up/confirm")
    String confirmMail(@RequestParam("token") String token) {
        Optional<ConfirmationToken> confirmationToken = confirmationTokenService.findByToken(token);
        confirmationToken.ifPresent(userService::confirmUser);
        return "redirect:/login";
    }
}
