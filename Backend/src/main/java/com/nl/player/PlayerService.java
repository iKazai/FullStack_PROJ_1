package com.nl.player;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByTeamName(String teamName) {
        return playerRepository.findByTeamName(teamName);
    }

    public List<Player> getPlayersByTeamSlug(String teamSlug) {
        return playerRepository.findByTeamSlug(teamSlug);
    }


}