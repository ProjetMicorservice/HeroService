package com.example.hero_service.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class InventoryDTO {
    private Long inventoryId;

    private int eggCount;

    private int incubatorCount;

    private Long heroId; // To represent the associated hero

    // Getters and setters

    // Constructors
}
