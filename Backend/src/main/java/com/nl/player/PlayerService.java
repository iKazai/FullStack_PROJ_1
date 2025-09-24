/**
 * Services disponibles au frontend pour interagir avec les joueurs.
 * Fournit des méthodes pour récupérer et filtrer les joueurs en fonction de divers critères.
 */

package com.nl.player;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

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

    public List<Player> getPlayersFromTeam(String teamName){
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam_name()))
                .toList();
    }

    public List<Player> getPlayerByLastName(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPlayer_last_name().toLowerCase().contains(searchText.toLowerCase()))
                .toList();  
    }
    public List<Player> getPlayerByFirstName(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPlayer_first_name().toLowerCase().contains(searchText.toLowerCase()))
                .toList();  
    }

    public List<Player> getPlayerByNation(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .toList();  
    }

    public List<Player> getPlayerByPosition(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPos().toLowerCase().contains(searchText.toLowerCase()))
                .toList();  
    }

    public List<Player> getPlayerByCollege(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getCollege() != null && player.getCollege().toLowerCase().contains(searchText.toLowerCase()))
                .toList();  
    }

    public List<Player> getPlayerByCountry(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getCountry() != null && player.getCountry().toLowerCase().contains(searchText.toLowerCase()))
                .toList();  
    }

    public List<Player> getPlayerByTeamCity(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getTeam_city().toLowerCase().contains(searchText.toLowerCase()))
                .toList();  
    }

    public List<Player> getPlayerByAge(Integer age) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getAge() != null && player.getAge().equals(age))
                .toList();
    }

    public List<Player> getPlayerByJerseyNumber(Integer jerseyNumber) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getJersey_number() != null && player.getJersey_number().equals(jerseyNumber))
                .toList();
    }

    public List<Player> getPlayerByDraftYear(Integer draftYear) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getDraft_year() != null && player.getDraft_year().equals(draftYear))
                .toList();
    }

    public List<Player> getPlayerByDraftRound(Integer draftRound) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getDraft_round() != null && player.getDraft_round().equals(draftRound))
                .toList();
    }

    public List<Player> getPlayerByDraftNumber(Integer draftNumber) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getDraft_number() != null && player.getDraft_number().equals(draftNumber))
                .toList();
    }

    public List<Player> getPlayerByWeight(Double weight) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getWeight() != null && player.getWeight().equals(weight))
                .toList();
    }

    public List<Player> getPlayerByHeight(String height) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getHeight() != null && player.getHeight().equals(height))
                .toList();
    }

    public List<Player> getPlayerByIsDefunct(Integer isDefunct) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getIs_defunct() != null && player.getIs_defunct().equals(isDefunct))
                .toList();
    }

    @Transactional
    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }

    public Player updatePlayer(Player player) {
        if(playerRepository.findByPersonId(player.getPerson_id()) != null) {
            playerRepository.deleteById(player.getPerson_id().toString());
            return addPlayer(player);
        }

        throw new IllegalArgumentException("Player with ID " + player.getPerson_id() + " does not exist.");

    }


}