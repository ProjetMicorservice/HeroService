package com.example.hero_service.Controller;

import com.example.hero_service.DTO.HeroDTO;
import com.example.hero_service.Service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @PostMapping
    public ResponseEntity<HeroDTO> createHero(@RequestBody HeroDTO heroDTO) {
        HeroDTO createdHero = heroService.createHero(heroDTO);
        return new ResponseEntity<>(createdHero, HttpStatus.CREATED);
    }

    @GetMapping("/{heroId}")
    public ResponseEntity<HeroDTO> getHeroById(@PathVariable Long heroId) {
        HeroDTO heroDTO = heroService.getHeroById(heroId);
        return new ResponseEntity<>(heroDTO, HttpStatus.OK);
    }

    @GetMapping("/byPlayer/{playerId}")
    public ResponseEntity<List<HeroDTO>> getHeroesByPlayerId(@PathVariable Long playerId) {
        List<HeroDTO> heroes = heroService.getHeroesByPlayerId(playerId);
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

    // Additional endpoints if needed
}
