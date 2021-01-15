package com.alexandru.videogamedistribution.repository;

import com.alexandru.videogamedistribution.embeddable.UserGameId;
import com.alexandru.videogamedistribution.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, UserGameId> {
}
