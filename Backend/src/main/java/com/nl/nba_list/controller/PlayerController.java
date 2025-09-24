package com.nl.nba_list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nl.nba_list.model.Player;
import com.nl.nba_list.model.PlayerFilterCriteria;
import com.nl.nba_list.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
        @RequestParam(required = false) String teamName,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String nation,
        @RequestParam(required = false) String position,
        @RequestParam(required = false) String college,
        @RequestParam(required = false) String country,
        @RequestParam(required = false) Integer age,
        @RequestParam(required = false) Integer jerseyNumber,
        @RequestParam(required = false) String teamCity,
        @RequestParam(required = false) String height,
        @RequestParam(required = false) Double weight,
        @RequestParam(required = false) Integer draftYear
    ) {
        // Créer un objet de critères de filtre
        PlayerFilterCriteria criteria = PlayerFilterCriteria.builder()
                .teamName(teamName)
                .lastName(lastName)
                .firstName(firstName)
                .nation(nation)
                .position(position)
                .college(college)
                .country(country)
                .age(age)
                .jerseyNumber(jerseyNumber)
                .teamCity(teamCity)
                .height(height)
                .weight(weight)
                .draftYear(draftYear)
                .build();
                
        return playerService.getFilteredPlayers(criteria);
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(player);
        if (updatedPlayer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    @DeleteMapping("/{playerLastName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerLastName) {
        playerService.deletePlayer(playerLastName);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }

}
