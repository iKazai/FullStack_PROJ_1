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
            criteria.getTeamName().contains(player.getTeam_name()))
            .filter(player -> criteria.getLastName() == null || 
            criteria.getLastName().contains(player.getPlayer_last_name()))
            .filter(player -> criteria.getFirstName() == null || 
            criteria.getFirstName().contains(player.getPlayer_first_name()))
            .filter(player -> criteria.getPosition() == null || 
            criteria.getPosition().contains(player.getPosition()))
            .filter(player -> criteria.getCollege() == null || 
            criteria.getCollege().contains(player.getCollege()))
            .filter(player -> criteria.getCountry() == null || 
            criteria.getCountry().contains(player.getCountry()))
            .filter(player -> criteria.getJerseyNumber() == null || 
            (player.getJersey_number() != null && criteria.getJerseyNumber().contains(player.getJersey_number())))
            .filter(player -> criteria.getTeamCity() == null || 
            (player.getTeam_city() != null && criteria.getTeamCity().contains(player.getTeam_city())))
            .filter(player -> criteria.getHeight() == null || 
            (player.getHeight() != null && criteria.getHeight().contains(player.getHeight())))
            .filter(player -> criteria.getWeight() == null || 
            (player.getWeight() != null && criteria.getWeight().contains(player.getWeight())))
            .filter(player -> criteria.getDraftYear() == null || 
            (player.getDraft_year() != null && criteria.getDraftYear().contains(player.getDraft_year())))
            .toList();
    }

    public List<Player> getPlayersFromTeam(List<String> teamNames){
        return playerRepository.findAll().stream()
                .filter(player -> teamNames.contains(player.getTeam_name()))
                .toList();
    }

    public List<Player> getPlayerByLastName(List<String> searchTexts) {
        return playerRepository.findAll().stream()
                .filter(player -> searchTexts.stream().anyMatch(text -> player.getPlayer_last_name().toLowerCase().contains(text.toLowerCase())))
                .toList();  
    }
    public List<Player> getPlayerByFirstName(List<String> searchTexts) {
        return playerRepository.findAll().stream()
                .filter(player -> searchTexts.stream().anyMatch(text -> player.getPlayer_first_name().toLowerCase().contains(text.toLowerCase())))
                .toList();  
    }

    public List<Player> getPlayerByPosition(List<String> searchTexts) {
        return playerRepository.findAll().stream()
                .filter(player -> searchTexts.stream().anyMatch(text -> player.getPosition().toLowerCase().contains(text.toLowerCase())))
                .toList();
    }

    public List<Player> getPlayerByCollege(List<String> searchTexts) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getCollege() != null && searchTexts.stream().anyMatch(text -> player.getCollege().toLowerCase().contains(text.toLowerCase())))
                .toList();  
    }

    public List<Player> getPlayerByCountry(List<String> searchTexts) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getCountry() != null && searchTexts.stream().anyMatch(text -> player.getCountry().toLowerCase().contains(text.toLowerCase())))
                .toList();
    }

    public List<Player> getPlayerByTeamCity(List<String> searchTexts) {
        return playerRepository.findAll().stream()
                .filter(player -> searchTexts.stream().anyMatch(text -> player.getTeam_city().toLowerCase().contains(text.toLowerCase())))
                .toList();  
    }

    public List<Player> getPlayerByJerseyNumber(Integer jerseyNumber) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getJersey_number() != null && player.getJersey_number().equals(jerseyNumber))
                .toList();
    }

    public List<Player> getPlayerByDraftYear(List<Integer> draftYears) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getDraft_year() != null && draftYears.contains(player.getDraft_year()))
                .toList();
    }

    public List<Player> getPlayerByDraftRound(List<Integer> draftRounds) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getDraft_round() != null && draftRounds.contains(player.getDraft_round()))
                .toList();
    }

    public List<Player> getPlayerByDraftNumber(List<Integer> draftNumbers) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getDraft_number() != null && draftNumbers.contains(player.getDraft_number()))
                .toList();
    }

    public List<Player> getPlayerByWeight(List<Double> weights) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getWeight() != null && weights.contains(player.getWeight()))
                .toList();
    }

    public List<Player> getPlayerByHeight(List<String> heights) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getHeight() != null && heights.contains(player.getHeight()))
                .toList();
    }

    public List<Player> getPlayerByIsDefunct(List<Integer> isDefunct) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getIs_defunct() != null && isDefunct.contains(player.getIs_defunct()))
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