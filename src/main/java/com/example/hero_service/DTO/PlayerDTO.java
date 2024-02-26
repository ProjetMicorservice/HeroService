package com.example.hero_service.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PlayerDTO {
    private Long playerId;
    private String playerName;
    private String email;
    private String password;
    // Getters and setters
    // Constructors
}
