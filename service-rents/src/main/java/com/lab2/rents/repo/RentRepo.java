package com.lab2.rents.repo;

import com.lab2.rents.repo.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepo extends JpaRepository<Rent, Long> {
}
