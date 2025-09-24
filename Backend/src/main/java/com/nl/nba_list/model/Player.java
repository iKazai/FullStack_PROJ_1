package com.nl.nba_list.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
@Table(name = "players_table")
public class Player {
    @Id
    @Column(name = "person_id", unique= true)
    private Integer person_id;

    private String player_last_name;
    private String player_first_name;
    private Integer team_id;
    private String position;  // Remplace 'pos'
    private Integer jersey_number;
    private String team_slug;
    private String height;
    private Double weight;
    private String college;
    private String country;  // Gardé, remplace 'nation'
    private Integer draft_year;
    private Integer is_defunct;
    private String team_city;
    private String team_name;
    private Integer draft_round;
    private Integer draft_number;
    private Integer from_year;
    private Integer to_year;
    private Double pts;
    private Double reb;
    private Double ast;


    public Player() {
    }

    public Player(Integer person_id,
                    String player_last_name,
                    String player_first_name,
                    Integer team_id,
                    String position,
                    Integer jersey_number,
                    String team_name,
                    String team_slug,
                    String height,
                    Double weight,
                    String college,
                    String country,
                    Integer draft_year,
                    Integer is_defunct,
                    String team_city,
                    Integer draft_round,
                    Integer draft_number,
                    Integer from_year,
                    Integer to_year,
                    Double pts,
                    Double reb,
                    Double ast) {
            this.person_id = person_id;
            this.player_last_name = player_last_name;
            this.player_first_name = player_first_name;
            this.team_id = team_id;
            this.position = position;
            this.jersey_number = jersey_number;
            this.team_name = team_name;
            this.team_slug = team_slug;
            this.height = height;
            this.weight = weight;
            this.college = college;
            this.country = country;
            this.draft_year = draft_year;
            this.is_defunct = is_defunct;
            this.team_city = team_city;
            this.draft_round = draft_round;
            this.draft_number = draft_number;
            this.from_year = from_year;
            this.to_year = to_year;
            this.pts = pts;
            this.reb = reb;
            this.ast = ast;
    }

    public Integer getPerson_id() { return person_id; }
    public void setPerson_id(Integer person_id) { this.person_id = person_id; }

    public String getPlayer_last_name() { return player_last_name; }
    public void setPlayer_last_name(String player_last_name) { this.player_last_name = player_last_name; }

    public String getPlayer_first_name() { return player_first_name; }
    public void setPlayer_first_name(String player_first_name) { this.player_first_name = player_first_name; }

    public Integer getTeam_id() { return team_id; }
    public void setTeam_id(Integer team_id) { this.team_id = team_id; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Integer getJersey_number() { return jersey_number; }
    public void setJersey_number(Integer jersey_number) { this.jersey_number = jersey_number; }

    public String getTeam_name() { return team_name; }
    public void setTeam_name(String team_name) { this.team_name = team_name; }

    public String getTeam_slug() { return team_slug; }
    public void setTeam_slug(String team_slug) { this.team_slug = team_slug; }

    public String getHeight() { return height; }
    public void setHeight(String height) { this.height = height; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public String getCollege() { return college; }
    public void setCollege(String college) { this.college = college; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Integer getDraft_year() { return draft_year; }
    public void setDraft_year(Integer draft_year) { this.draft_year = draft_year; }

    public Integer getIs_defunct() { return is_defunct; }
    public void setIs_defunct(Integer is_defunct) { this.is_defunct = is_defunct; }

    public String getTeam_city() { return team_city; }
    public void setTeam_city(String team_city) { this.team_city = team_city; }

    public Integer getDraft_round() { return draft_round; }
    public void setDraft_round(Integer draft_round) { this.draft_round = draft_round; }

    public Integer getDraft_number() { return draft_number; }
    public void setDraft_number(Integer draft_number) { this.draft_number = draft_number; }

    public Integer getFrom_year() { return from_year; }
    public void setFrom_year(Integer from_year) { this.from_year = from_year; }

    public Integer getTo_year() { return to_year; }
    public void setTo_year(Integer to_year) { this.to_year = to_year; }

    public Double getPts() { return pts; }
    public void setPts(Double pts) { this.pts = pts; }

    public Double getReb() { return reb; }
    public void setReb(Double reb) { this.reb = reb; }

    public Double getAst() { return ast; }
    public void setAst(Double ast) { this.ast = ast; }
}
