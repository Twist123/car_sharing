package com.lab2.rents.api;

import com.lab2.rents.api.dto.RentItem;
import com.lab2.rents.repo.model.Rent;
import com.lab2.rents.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rent")
public final class RentController {

    private final RentService rentService;

    @GetMapping
    public ResponseEntity<List<Rent>> list() {
        List<Rent> items = rentService.list();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rent> read(@PathVariable long id) {
        try {
            Rent item = rentService.read(id);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Rent> create(@RequestBody RentItem rent) {
        try {
            Long userId = rent.getUserId();
            String info = rent.getInfo();
            Integer status = rent.getStatus();
            Rent item = rentService.create(userId, info, status);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Rent> update(@PathVariable long id, @RequestBody RentItem rent) {
        try {
            Long userId = rent.getUserId();
            String info = rent.getInfo();
            Integer status = rent.getStatus();
            Rent item = rentService.update(id, userId, info, status);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RentItem> remove(@PathVariable long id) {
        rentService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
