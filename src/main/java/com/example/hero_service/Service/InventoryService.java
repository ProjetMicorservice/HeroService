package com.example.hero_service.Service;


import com.example.hero_service.DTO.InventoryDTO;

public interface InventoryService {
    InventoryDTO createInventory(InventoryDTO inventoryDTO);
    InventoryDTO getInventoryByHeroId(Long inventoryId);
}
