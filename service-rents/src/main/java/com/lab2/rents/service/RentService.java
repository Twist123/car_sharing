package com.lab2.rents.service;

import com.lab2.rents.repo.RentRepo;
import com.lab2.rents.repo.model.Rent;
import com.lab2.rents.repo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class RentService {

    private final RentRepo rentRepo;

    public List<Rent> list() {
        final List<Rent> items = rentRepo.findAll();
        return items;
    }

    public Rent read(long id) throws IllegalArgumentException {
        final Optional<Rent> item = rentRepo.findById(id);
        if (item.isEmpty()) {
            throw new IllegalArgumentException("Rent unknown");
        }
        return item.get();
    }

    public Rent create(Long userId, String info, Integer status) throws IllegalArgumentException{
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:8081/identity/{id}";
        Map<String, Long> map = new HashMap<>();
        map.put("id", userId);
        ResponseEntity<User> user = rt.getForEntity(url, User.class, map);
        if (user.getStatusCode() != HttpStatus.OK || user.getBody().getStatus() != 1) {
            throw new IllegalArgumentException("User unknown");
        }

        final Rent rent = new Rent(userId, info, status);
        final Rent item = rentRepo.save(rent);
        return item;
    }

    public Rent update(long id, Long userId, String info, Integer status) throws IllegalArgumentException {
        final Optional<Rent> item = rentRepo.findById(id);
        if (item.isEmpty()) {
            throw new IllegalArgumentException("Rent unknown");
        }
        Rent rent = item.get();
        if (userId != null && userId > 0) {
            RestTemplate rt = new RestTemplate();
            String url = "http://localhost:8081/identity/{id}";
            Map<String, Long> map = new HashMap<>();
            map.put("id", userId);
            ResponseEntity<User> user = rt.getForEntity(url, User.class, map);
            if (user.getStatusCode() != HttpStatus.OK || user.getBody().getStatus() != 1) {
                throw new IllegalArgumentException("User unknown");
            }
            rent.setUserId(userId);
        }
        if (info != null && !info.isBlank()) {
            rent.setInfo(info);
        }
        if (status != null) {
            rent.setStatus(status);
        }
        rentRepo.save(rent);
        return rent;
    }

    public void remove(long id) {
        rentRepo.deleteById(id);
    }
}
