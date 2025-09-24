/**
 * Services disponibles au frontend pour interagir avec les joueurs.
 * Fournit des méthodes pour récupérer et filtrer les joueurs en fonction de divers critères.
 */

package com.nl.nba_list.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.nl.nba_list.model.Player;
import com.nl.nba_list.model.PlayerFilterCriteria;
import com.nl.nba_list.repository.PlayerRepository;

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

    /**
     * Nouvelle méthode pour filtrer avec plusieurs critères simultanément
     */
    public List<Player> getFilteredPlayers(PlayerFilterCriteria criteria) {
        // Si aucun filtre n'est défini, retourner tous les joueurs
        if (criteria.hasNoFilters()) {
            return playerRepository.findAll();
        }

        // Appliquer tous les filtres de manière chaînée
        return playerRepository.findAll().stream()
            .filter(player -> criteria.getTeamName() == null || 
                    (player.getTeam_name() != null && player.getTeam_name().toLowerCase().contains(criteria.getTeamName().toLowerCase())))
            .filter(player -> criteria.getLastName() == null || 
                    (player.getPlayer_last_name() != null && player.getPlayer_last_name().toLowerCase().contains(criteria.getLastName().toLowerCase())))
            .filter(player -> criteria.getFirstName() == null || 
                    (player.getPlayer_first_name() != null && player.getPlayer_first_name().toLowerCase().contains(criteria.getFirstName().toLowerCase())))
            .filter(player -> criteria.getNation() == null || 
                    (player.getNation() != null && player.getNation().toLowerCase().contains(criteria.getNation().toLowerCase())))
            .filter(player -> criteria.getPosition() == null || 
                    (player.getPos() != null && player.getPos().toLowerCase().contains(criteria.getPosition().toLowerCase())))
            .filter(player -> criteria.getCollege() == null || 
                    (player.getCollege() != null && player.getCollege().toLowerCase().contains(criteria.getCollege().toLowerCase())))
            .filter(player -> criteria.getCountry() == null || 
                    (player.getCountry() != null && player.getCountry().toLowerCase().contains(criteria.getCountry().toLowerCase())))
            .filter(player -> criteria.getAge() == null || 
                    (player.getAge() != null && player.getAge().equals(criteria.getAge())))
            .filter(player -> criteria.getJerseyNumber() == null || 
                    (player.getJersey_number() != null && player.getJersey_number().equals(criteria.getJerseyNumber())))
            .filter(player -> criteria.getTeamCity() == null || 
                    (player.getTeam_city() != null && player.getTeam_city().toLowerCase().contains(criteria.getTeamCity().toLowerCase())))
            .filter(player -> criteria.getHeight() == null || 
                    (player.getHeight() != null && player.getHeight().equals(criteria.getHeight())))
            .filter(player -> criteria.getWeight() == null || 
                    (player.getWeight() != null && player.getWeight().equals(criteria.getWeight())))
            .filter(player -> criteria.getDraftYear() == null || 
                    (player.getDraft_year() != null && player.getDraft_year().equals(criteria.getDraftYear())))
            .toList();
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

    public void deletePlayer(String playerLastName) {
        playerRepository.deleteByPlayerLastName(playerLastName);
    }

    public Player updatePlayer(Player player) {
        if(playerRepository.findByPersonId(player.getPerson_id()) != null) {
            playerRepository.deleteByPlayerLastName(player.getPlayer_last_name());
            return addPlayer(player);
        }

        throw new IllegalArgumentException("Player with ID " + player.getPerson_id() + " does not exist.");

    }


}