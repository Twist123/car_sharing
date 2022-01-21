package com.lab2.identities.repo;

import com.lab2.identities.repo.model.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityRepo extends JpaRepository<Identity, Long> {
}
