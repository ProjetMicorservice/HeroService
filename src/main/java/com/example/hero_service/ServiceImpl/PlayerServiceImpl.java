package com.example.hero_service.ServiceImpl;

import com.example.hero_service.DTO.PlayerDTO;
import com.example.hero_service.Repository.PlayerRepository;
import com.example.hero_service.Service.PlayerService;
import com.example.hero_service.model.Player;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setPlayerName(playerDTO.getPlayerName());
        player.setEmail(playerDTO.getEmail());
        player.setPassword(playerDTO.getPassword());

        Player savedPlayer = playerRepository.save(player);

        PlayerDTO savedPlayerDTO = new PlayerDTO();
        savedPlayerDTO.setPlayerId(savedPlayer.getPlayerId());
        savedPlayerDTO.setPlayerName(savedPlayer.getPlayerName());
        savedPlayerDTO.setEmail(savedPlayer.getEmail());

        return savedPlayerDTO;
    }

    @Override
    public PlayerDTO getPlayerById(Long playerId) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);

        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();

            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setPlayerId(player.getPlayerId());
            playerDTO.setPlayerName(player.getPlayerName());
            playerDTO.setEmail(player.getEmail());

            return playerDTO;
        } else {
            throw new EntityNotFoundException("Player with ID " + playerId + " not found");
        }
    }
    // Additional methods as needed
}

