package com.alexandru.videogamedistribution.service;

import com.alexandru.videogamedistribution.entity.ConfirmationToken;
import com.alexandru.videogamedistribution.entity.User;
import com.alexandru.videogamedistribution.repository.ConfirmationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public String newConfirmationToken(User user) {
        return save(new ConfirmationToken(user)).getToken();
    }

    public ConfirmationToken save(ConfirmationToken confirmationToken) {
        return confirmationTokenRepository.save(confirmationToken);
    }

    public void deleteById(int id) {
        confirmationTokenRepository.deleteById(id);
    }

    public Optional<ConfirmationToken> findByToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }
}
