package com.example.hero_service.Service;

import com.example.hero_service.DTO.HeroDTO;

import java.util.List;

public interface HeroService {
    HeroDTO createHero(HeroDTO heroDTO);

    HeroDTO getHeroById(Long heroId);

    List<HeroDTO> getHeroesByPlayerId(Long playerId);

    // Additional methods as needed
}
