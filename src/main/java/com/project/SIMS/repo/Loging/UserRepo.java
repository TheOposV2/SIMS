package com.project.SIMS.repo.Loging;

import com.project.SIMS.model.Logging.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

  Users findByUsername(String username);
}
