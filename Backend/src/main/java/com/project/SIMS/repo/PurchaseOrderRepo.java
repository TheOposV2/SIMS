package com.project.SIMS.repo;

import com.project.SIMS.model.purchaseOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepo extends JpaRepository<purchaseOrders, Integer> {
}
