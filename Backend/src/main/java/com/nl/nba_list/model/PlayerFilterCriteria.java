package com.nl.nba_list.model;

import java.util.List;
/**
 * Classe pour encapsuler les critères de filtrage des joueurs
 */
public class PlayerFilterCriteria {
    private List<String> teamName;
    private List<String> lastName;
    private List<String> firstName;
    private List<String> position;
    private List<String> college;
    private List<String> country;
    private List<Integer> jerseyNumber;
    private List<String> teamCity;
    private List<String> height;
    private List<Double> weight;
    private List<Integer> draftYear;

    // Constructeur privé pour le pattern Builder
    private PlayerFilterCriteria(Builder builder) {
        this.teamName = builder.teamName;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.position = builder.position;
        this.college = builder.college;
        this.country = builder.country;
        this.jerseyNumber = builder.jerseyNumber;
        this.teamCity = builder.teamCity;
        this.height = builder.height;
        this.weight = builder.weight;
        this.draftYear = builder.draftYear;
    }

    // Méthode statique pour créer un Builder
    public static Builder builder() {
        return new Builder();
    }

    // Pattern Builder
    public static class Builder {
        private List<String> teamName;
        private List<String> lastName;
        private List<String> firstName;
        private List<String> position;
        private List<String> college;
        private List<String> country;
        private List<Integer> jerseyNumber;
        private List<String> teamCity;
        private List<String> height;
        private List<Double> weight;
        private List<Integer> draftYear;

        public Builder teamName(List<String> teamName) {
            this.teamName = teamName;
            return this;
        }

        public Builder lastName(List<String> lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(List<String> firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder position(List<String> position) {
            this.position = position;
            return this;
        }

        public Builder college(List<String> college) {
            this.college = college;
            return this;
        }

        public Builder country(List<String> country) {
            this.country = country;
            return this;
        }

        public Builder jerseyNumber(List<Integer> jerseyNumber) {
            this.jerseyNumber = jerseyNumber;
            return this;
        }

        public Builder teamCity(List<String> teamCity) {
            this.teamCity = teamCity;
            return this;
        }

        public Builder height(List<String> height) {
            this.height = height;
            return this;
        }

        public Builder weight(List<Double> weight) {
            this.weight = weight;
            return this;
        }

        public Builder draftYear(List<Integer> draftYear) {
            this.draftYear = draftYear;
            return this;
        }

        public PlayerFilterCriteria build() {
            return new PlayerFilterCriteria(this);
        }
    }

    // Méthode pour vérifier si aucun filtre n'est défini
    public boolean hasNoFilters() {
        return teamName == null && lastName == null && firstName == null && 
               position == null && college == null && 
               country == null && jerseyNumber == null && 
               teamCity == null && height == null && weight == null && draftYear == null;
    }

    // Getters
    public List<String> getTeamName() { return teamName; }
    public List<String> getLastName() { return lastName; }
    public List<String> getFirstName() { return firstName; }
    public List<String> getPosition() { return position; }
    public List<String> getCollege() { return college; }
    public List<String> getCountry() { return country; }
    public List<Integer> getJerseyNumber() { return jerseyNumber; }
    public List<String> getTeamCity() { return teamCity; }
    public List<String> getHeight() { return height; }
    public List<Double> getWeight() { return weight; }
    public List<Integer> getDraftYear() { return draftYear; }
}