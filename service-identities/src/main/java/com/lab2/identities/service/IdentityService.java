package com.lab2.identities.service;

import com.lab2.identities.repo.IdentityRepo;
import com.lab2.identities.repo.model.Identity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class IdentityService {

    private final IdentityRepo identityRepo;

    public List<Identity> list() {
        final List<Identity> items = identityRepo.findAll();
        return items;
    }

    public Identity read(long id) throws IllegalArgumentException {
        final Optional<Identity> item = identityRepo.findById(id);
        if (item.isEmpty()) {
            throw new IllegalArgumentException("Identity unknown");
        }
        return item.get();
    }

    public Identity create(String login, String password, Boolean moderator, Integer status) {
        final Identity identity = new Identity(login, password, moderator, status);
        final Identity item = identityRepo.save(identity);
        return item;
    }

    public Identity update(long id, String login, String password, Boolean moderator, Integer status) throws IllegalArgumentException {
        final Optional<Identity> item = identityRepo.findById(id);
        if (item.isEmpty()) {
            throw new IllegalArgumentException("Identity unknown");
        }
        Identity identity = item.get();
        if (login != null && !login.isBlank()) {
            identity.setLogin(login);
        }
        if (password != null && !password.isBlank()) {
            identity.setPassword(password);
            String passwordHash = password;
            identity.setPasswordHash(passwordHash);
        }
        if (moderator != null) {
            identity.setModerator(moderator);
        }
        if (status != null) {
            identity.setStatus(status );
        }
        identityRepo.save(identity);
        return identity;
    }

    public void remove(long id) {
        identityRepo.deleteById(id);
    }
}
