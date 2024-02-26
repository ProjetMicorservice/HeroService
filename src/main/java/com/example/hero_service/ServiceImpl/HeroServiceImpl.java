package com.example.hero_service.ServiceImpl;

import com.example.hero_service.DTO.HeroDTO;
import com.example.hero_service.Repository.HeroRepository;
import com.example.hero_service.Repository.PlayerRepository;
import com.example.hero_service.Service.HeroService;
import com.example.hero_service.model.Hero;
import com.example.hero_service.model.Player;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public HeroDTO createHero(HeroDTO heroDTO) {
        Hero hero = new Hero();
        hero.setHeroName(heroDTO.getHeroName());
        hero.setLevel(heroDTO.getLevel());
        hero.setExperience(heroDTO.getExperience());

        Optional<Player> optionalPlayer = playerRepository.findById(heroDTO.getPlayerId());
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            hero.setPlayer(player);
        } else {
            throw new EntityNotFoundException("Player with ID " + heroDTO.getPlayerId() + " not found");
        }

        Hero savedHero = heroRepository.save(hero);

        HeroDTO savedHeroDTO = new HeroDTO();
        savedHeroDTO.setHeroId(savedHero.getHeroId());
        savedHeroDTO.setHeroName(savedHero.getHeroName());
        savedHeroDTO.setLevel(savedHero.getLevel());
        savedHeroDTO.setExperience(savedHero.getExperience());

        return savedHeroDTO;
    }

    @Override
    public HeroDTO getHeroById(Long heroId) {
        Optional<Hero> optionalHero = heroRepository.findById(heroId);

        if (optionalHero.isPresent()) {
            Hero hero = optionalHero.get();

            HeroDTO heroDTO = new HeroDTO();
            heroDTO.setHeroId(hero.getHeroId());
            heroDTO.setHeroName(hero.getHeroName());
            heroDTO.setLevel(hero.getLevel());
            heroDTO.setExperience(hero.getExperience());
            heroDTO.setPlayerId(hero.getPlayer().getPlayerId());

            return heroDTO;
        } else {
            throw new EntityNotFoundException("Hero with ID " + heroId + " not found");
        }
    }

    @Override
    public List<HeroDTO> getHeroesByPlayerId(Long playerId) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);

        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            List<Hero> heroes = heroRepository.findByPlayer(player);

            return heroes.stream()
                    .map(hero -> {
                        HeroDTO heroDTO = new HeroDTO();
                        heroDTO.setHeroId(hero.getHeroId());
                        heroDTO.setHeroName(hero.getHeroName());
                        heroDTO.setLevel(hero.getLevel());
                        heroDTO.setExperience(hero.getExperience());
                        heroDTO.setPlayerId(hero.getPlayer().getPlayerId());
                        return heroDTO;
                    })
                    .collect(Collectors.toList());
        } else {
            throw new EntityNotFoundException("Player with ID " + playerId + " not found");
        }
    }
    // Additional methods as needed
}
