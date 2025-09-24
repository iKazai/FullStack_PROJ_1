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
    private String nation;
    private Integer age;
    private Integer team_id;
    private String pos;
    private Integer jersey_number;
    private String team_slug;
    private String height;
    private Double weight;
    private String college;
    private String country;
    private Integer draft_year;
    private Integer is_defunct;
    private String team_city;
    private String team_name;
    private String team_abbrevation;
    private Integer draft_round;
    private Integer draft_number;
    private Integer roster_status;
    private Integer from_year;
    private Integer to_year;
    private Double pts;
    private Double reb;
    private Double ast;
    private String stat_timeframe;
    private String player_last_initial;
    private String historic;


    public Player() {
    }

    public Player(Integer person_id,
                    String player_last_name,
                    String player_first_name,
                    String nation,
                    Integer age,
                    Integer team_id,
                    String pos,
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
                    String team_abbrevation,
                    Integer draft_round,
                    Integer draft_number,
                    Integer roster_status,
                    Integer from_year,
                    Integer to_year,
                    Double pts,
                    Double reb,
                    Double ast,
                    String stat_timeframe,
                    String player_last_initial,
                    String historic) {
            this.person_id = person_id;
            this.player_last_name = player_last_name;
            this.player_first_name = player_first_name;
            this.nation = nation;
            this.age = age;
            this.team_id = team_id;
            this.pos = pos;
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
            this.team_name = team_name;
            this.team_abbrevation = team_abbrevation;
            this.draft_round = draft_round;
            this.draft_number = draft_number;
            this.roster_status = roster_status;
            this.from_year = from_year;
            this.to_year = to_year;
            this.pts = pts;
            this.reb = reb;
            this.ast = ast;
            this.stat_timeframe = stat_timeframe;
            this.player_last_initial = player_last_initial;
            this.historic = historic;
    }

    public Integer getPerson_id() { return person_id; }
    public void setPerson_id(Integer person_id) { this.person_id = person_id; }

    public String getPlayer_last_name() { return player_last_name; }
    public void setPlayer_last_name(String player_last_name) { this.player_last_name = player_last_name; }

    public String getPlayer_first_name() { return player_first_name; }
    public void setPlayer_first_name(String player_first_name) { this.player_first_name = player_first_name; }

    public String getNation() { return nation; }
    public void setNation(String nation) { this.nation = nation; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Integer getTeam_id() { return team_id; }
    public void setTeam_id(Integer team_id) { this.team_id = team_id; }

    public String getPos() { return pos; }
    public void setPos(String pos) { this.pos = pos; }

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

    public String getTeam_abbrevation() { return team_abbrevation; }
    public void setTeam_abbrevation(String team_abbrevation) { this.team_abbrevation = team_abbrevation; }

    public Integer getDraft_round() { return draft_round; }
    public void setDraft_round(Integer draft_round) { this.draft_round = draft_round; }

    public Integer getDraft_number() { return draft_number; }
    public void setDraft_number(Integer draft_number) { this.draft_number = draft_number; }

    public Integer getRoster_status() { return roster_status; }
    public void setRoster_status(Integer roster_status) { this.roster_status = roster_status; }

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

    public String getStat_timeframe() { return stat_timeframe; }
    public void setStat_timeframe(String stat_timeframe) { this.stat_timeframe = stat_timeframe; }

    public String getPlayer_last_initial() { return player_last_initial; }
    public void setPlayer_last_initial(String player_last_initial) { this.player_last_initial = player_last_initial; }

    public String getHistoric() { return historic; }
    public void setHistoric(String historic) { this.historic = historic; }




    
}
