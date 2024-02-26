package com.example.hero_service.Repository;

import com.example.hero_service.model.Hero;
import com.example.hero_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByHero(Hero hero);
}
