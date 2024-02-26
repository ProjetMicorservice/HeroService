package com.example.hero_service.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HeroDTO {
    private Long heroId;
    private String heroName;
    private int level;
    private int experience;
    private Long playerId; // To represent the associated player

    // Getters and setters

    // Constructors
}
