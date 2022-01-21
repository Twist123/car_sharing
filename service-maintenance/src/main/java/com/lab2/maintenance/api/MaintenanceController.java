package com.lab2.maintenance.api;

import com.lab2.maintenance.api.dto.MaintenanceItem;
import com.lab2.maintenance.repo.model.Maintenance;
import com.lab2.maintenance.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/maintenance")
public final class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @GetMapping
    public ResponseEntity<List<Maintenance>> list() {
        List<Maintenance> items = maintenanceService.list();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> read(@PathVariable long id) {
        try {
            Maintenance item = maintenanceService.read(id);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Maintenance> create(@RequestBody MaintenanceItem rent) {
        try {
            Integer volume = rent.getVolume();
            Integer weight = rent.getWeight();
            String pointFrom = rent.getPointFrom();
            String pointTo = rent.getPointTo();
            Integer status = rent.getStatus();
            Maintenance item = maintenanceService.create(volume, weight, pointFrom, pointTo, status);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Maintenance> update(@PathVariable long id, @RequestBody MaintenanceItem rent) {
        try {
            Integer volume = rent.getVolume();
            Integer weight = rent.getWeight();
            String pointFrom = rent.getPointFrom();
            String pointTo = rent.getPointTo();
            Integer status = rent.getStatus();
            Maintenance item = maintenanceService.update(id, volume, weight, pointFrom, pointTo, status);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MaintenanceItem> remove(@PathVariable long id) {
        maintenanceService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
