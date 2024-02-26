package com.example.hero_service.Repository;

import com.example.hero_service.model.Hero;
import com.example.hero_service.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Long> {
    List<Hero> findByPlayer(Player player);
}
