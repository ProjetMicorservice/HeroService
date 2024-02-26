package com.example.hero_service.Service;

import com.example.hero_service.DTO.PlayerDTO;

public interface PlayerService {
    PlayerDTO createPlayer(PlayerDTO playerDTO);
    PlayerDTO getPlayerById(Long id);
}
