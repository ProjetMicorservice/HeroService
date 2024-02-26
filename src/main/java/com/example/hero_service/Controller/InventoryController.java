package com.example.hero_service.Controller;

import com.example.hero_service.DTO.InventoryDTO;
import com.example.hero_service.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<InventoryDTO> createInventory(@RequestBody InventoryDTO inventoryDTO) {
        InventoryDTO createdInventory = inventoryService.createInventory(inventoryDTO);
        return new ResponseEntity<>(createdInventory, HttpStatus.CREATED);
    }

    @GetMapping("/byHero/{heroId}")
    public ResponseEntity<InventoryDTO> getInventoryByHeroId(@PathVariable Long heroId) {
        InventoryDTO inventoryDTO = inventoryService.getInventoryByHeroId(heroId);
        return new ResponseEntity<>(inventoryDTO, HttpStatus.OK);
    }

    // Additional endpoints if needed
}
