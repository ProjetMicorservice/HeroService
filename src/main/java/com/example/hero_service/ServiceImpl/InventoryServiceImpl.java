package com.example.hero_service.ServiceImpl;

import com.example.hero_service.DTO.InventoryDTO;
import com.example.hero_service.Repository.HeroRepository;
import com.example.hero_service.Repository.InventoryRepository;
import com.example.hero_service.Service.InventoryService;
import com.example.hero_service.model.Hero;
import com.example.hero_service.model.Inventory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public InventoryDTO createInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = new Inventory();
        inventory.setEggCount(inventoryDTO.getEggCount());
        inventory.setIncubatorCount(inventoryDTO.getIncubatorCount());

        Optional<Hero> optionalHero = heroRepository.findById(inventoryDTO.getHeroId());
        if (optionalHero.isPresent()) {
            Hero hero = optionalHero.get();
            inventory.setHero(hero);
        } else {
            throw new EntityNotFoundException("Hero with ID " + inventoryDTO.getHeroId() + " not found");
        }

        Inventory savedInventory = inventoryRepository.save(inventory);

        InventoryDTO savedInventoryDTO = new InventoryDTO();
        savedInventoryDTO.setInventoryId(savedInventory.getInventoryId());
        savedInventoryDTO.setEggCount(savedInventory.getEggCount());
        savedInventoryDTO.setIncubatorCount(savedInventory.getIncubatorCount());
        savedInventoryDTO.setHeroId(savedInventory.getHero().getHeroId());

        return savedInventoryDTO;
    }

    @Override
    public InventoryDTO getInventoryByHeroId(Long heroId) {
        Optional<Hero> optionalHero = heroRepository.findById(heroId);

        if (optionalHero.isPresent()) {
            Hero hero = optionalHero.get();
            Optional<Inventory> optionalInventory = inventoryRepository.findByHero(hero);

            if (optionalInventory.isPresent()) {
                Inventory inventory = optionalInventory.get();

                InventoryDTO inventoryDTO = new InventoryDTO();
                inventoryDTO.setInventoryId(inventory.getInventoryId());
                inventoryDTO.setEggCount(inventory.getEggCount());
                inventoryDTO.setIncubatorCount(inventory.getIncubatorCount());
                inventoryDTO.setHeroId(inventory.getHero().getHeroId());

                return inventoryDTO;
            } else {
                throw new EntityNotFoundException("Inventory for Hero with ID " + heroId + " not found");
            }
        } else {
            throw new EntityNotFoundException("Hero with ID " + heroId + " not found");
        }
    }
    // Additional methods as needed
}

