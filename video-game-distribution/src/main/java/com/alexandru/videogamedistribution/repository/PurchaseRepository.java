package com.alexandru.videogamedistribution.repository;

import com.alexandru.videogamedistribution.embeddable.UserGameId;
import com.alexandru.videogamedistribution.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, UserGameId> {
}
