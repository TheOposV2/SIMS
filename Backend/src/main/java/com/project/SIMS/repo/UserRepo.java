package com.project.SIMS.repo;

import com.project.SIMS.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

  Users findByUsername(String username);
}
