package com.alexandru.videogamedistribution.service;

import com.alexandru.videogamedistribution.dto.UserDto;
import com.alexandru.videogamedistribution.entity.ConfirmationToken;
import com.alexandru.videogamedistribution.entity.User;
import com.alexandru.videogamedistribution.exception.UserAlreadyExistsException;
import com.alexandru.videogamedistribution.repository.RoleRepository;
import com.alexandru.videogamedistribution.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.*;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MailSenderService mailSenderService;
    private final ConfirmationTokenService confirmationTokenService;

    void sendConfirmationMail(String userMail, String token) {
        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Video Game Distribution - Mail confirmation link");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText("Thank you for registering. Please click the following link to activate your account: " +
                            "http://localhost:8080/sign-up/confirm?token=" + token);
        mailSenderService.sendEmail(mailMessage);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email)));
    }

    public void registerNewUserAccount(UserDto userDto) throws UserAlreadyExistsException {

        if (emailExists(userDto.getEmail())) { throw new UserAlreadyExistsException("There is already an account registered for " + userDto.getEmail()); }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRoles(Collections.singletonList(roleRepository.findByName("ROLE_USER")));
        userRepository.save(user);
        sendConfirmationMail(user.getEmail(), confirmationTokenService.newConfirmationToken(user));
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public void confirmUser(ConfirmationToken confirmationToken) {
        final User user = confirmationToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        confirmationTokenService.deleteById(confirmationToken.getId());
    }
}
