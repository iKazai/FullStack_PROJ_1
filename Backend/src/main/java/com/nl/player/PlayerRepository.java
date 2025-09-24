package com.nl.player;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    void deleteByName(String playerName);
    Optional<Player> findByPersonId(Integer person_id);
    List<Player> findByTeamSlug(String team_slug);
    List<Player> findByTeamId(Integer team_id);
    List<Player> findByPlayerLastName(String player_last_name);
    List<Player> findByPlayerFirstName(String player_first_name);
    List<Player> findByNation(String nation);
    List<Player> findByAge(Integer age);
    List<Player> findByPos(String pos);
    List<Player> findByJerseyNumber(Integer jersey_number);
    List<Player> findByHeight(String height);
    List<Player> findByWeight(Double weight);
    List<Player> findByCollege(String college);
    List<Player> findByCountry(String country);
    List<Player> findByDraftYear(Integer draft_year);
    List<Player> findByIsDefunct(Integer is_defunct);
    List<Player> findByTeamCity(String team_city);
    List<Player> findByTeamName(String team_name);
    List<Player> findByTeamAbbrevation(String team_abbrevation);
    List<Player> findByDraftRound(Integer draft_round);
    List<Player> findByDraftNumber(Integer draft_number);
    List<Player> findByRosterStatus(Integer roster_status);
    List<Player> findByFromYear(Integer from_year);
    List<Player> findByToYear(Integer to_year);
    List<Player> findByPts(Double pts);
    List<Player> findByReb(Double reb);
    List<Player> findByAst(Double ast);
    List<Player> findByStatTimeframe(String stat_timeframe);
    List<Player> findByPlayerLastInitial(String player_last_initial);
    List<Player> findByHistoric(String historic);  
}
