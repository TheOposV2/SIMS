package com.project.SIMS.repo;

import com.project.SIMS.model.salesRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRecordsRepo extends JpaRepository<salesRecords, Integer> {
}
