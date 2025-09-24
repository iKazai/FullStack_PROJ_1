package com.nl.nba_list.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import com.nl.nba_list.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Player p WHERE p.player_last_name = :playerLastName")
    void deleteByPlayerLastName(@Param("playerLastName") String playerLastName);
    
    @Query("SELECT p FROM Player p WHERE p.person_id = :personId")
    Optional<Player> findByPersonId(@Param("personId") Integer personId);
}
