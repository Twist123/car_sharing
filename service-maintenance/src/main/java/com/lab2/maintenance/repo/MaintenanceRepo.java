package com.lab2.maintenance.repo;

import com.lab2.maintenance.repo.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepo extends JpaRepository<Maintenance, Long> {
}
