package com.lab2.identities.api;

import com.lab2.identities.api.dto.IdentityItem;
import com.lab2.identities.repo.model.Identity;
import com.lab2.identities.service.IdentityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/identity")
public final class IdentityController {

    private final IdentityService identityService;

    @GetMapping
    public ResponseEntity<List<Identity>> list() {
        List<Identity> items = identityService.list();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Identity> read(@PathVariable long id) {
        try {
            Identity item = identityService.read(id);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Identity> create(@RequestBody IdentityItem identity) {
        try {
            String login = identity.getLogin();
            String password = identity.getPassword();
            Boolean moderator = identity.getModerator();
            Integer status = identity.getStatus();
            Identity item = identityService.create(login, password, moderator, status);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Identity> update(@PathVariable long id, @RequestBody IdentityItem identity) {
        try {
            String login = identity.getLogin();
            String password = identity.getPassword();
            Boolean moderator = identity.getModerator();
            Integer status = identity.getStatus();
            Identity item = identityService.update(id, login, password, moderator, status);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<IdentityItem> remove(@PathVariable long id) {
        identityService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
