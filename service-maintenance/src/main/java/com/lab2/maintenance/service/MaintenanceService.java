package com.lab2.maintenance.service;

import com.lab2.maintenance.repo.MaintenanceRepo;
import com.lab2.maintenance.repo.model.Maintenance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class MaintenanceService {

    private final MaintenanceRepo maintenanceRepo;

    public List<Maintenance> list() {
        final List<Maintenance> items = maintenanceRepo.findAll();
        return items;
    }

    public Maintenance read(long id) throws IllegalArgumentException {
        final Optional<Maintenance> item = maintenanceRepo.findById(id);
        if (item.isEmpty()) {
            throw new IllegalArgumentException("Rent unknown");
        }
        return item.get();
    }

    public Maintenance create(Integer volume, Integer weight, String pointFrom, String pointTo, Integer status) {
        final Maintenance maintenance = new Maintenance(volume, weight, pointFrom, pointTo, status);
        final Maintenance item = maintenanceRepo.save(maintenance);
        return item;
    }

    public Maintenance update(long id, Integer volume, Integer weight, String pointFrom, String pointTo, Integer status) throws IllegalArgumentException {
        final Optional<Maintenance> item = maintenanceRepo.findById(id);
        if (item.isEmpty()) {
            throw new IllegalArgumentException("Rent unknown");
        }
        Maintenance maintenance = item.get();
        if (volume != null && volume > 0) {
            maintenance.setVolume(volume);
        }
        if (weight != null && weight > 0) {
            maintenance.setWeight(weight);
        }
        if (pointFrom != null && !pointFrom.isBlank()) {
            maintenance.setPointFrom(pointFrom);
        }
        if (pointTo != null && !pointTo.isBlank()) {
            maintenance.setPointTo(pointTo);
        }
        if (status != null) {
            maintenance.setStatus(status );
        }
        maintenanceRepo.save(maintenance);
        return maintenance;
    }

    public void remove(long id) {
        maintenanceRepo.deleteById(id);
    }
}
