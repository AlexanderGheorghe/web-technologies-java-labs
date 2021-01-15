package com.alexandru.videogamedistribution.repository;

import com.alexandru.videogamedistribution.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
