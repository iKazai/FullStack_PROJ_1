package com.nl.nba_list.model;

/**
 * Classe pour encapsuler les critères de filtrage des joueurs
 */
public class PlayerFilterCriteria {
    private String teamName;
    private String lastName;
    private String firstName;
    private String nation;
    private String position;
    private String college;
    private String country;
    private Integer age;
    private Integer jerseyNumber;
    private String teamCity;
    private String height;
    private Double weight;
    private Integer draftYear;

    // Constructeur privé pour le pattern Builder
    private PlayerFilterCriteria(Builder builder) {
        this.teamName = builder.teamName;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.nation = builder.nation;
        this.position = builder.position;
        this.college = builder.college;
        this.country = builder.country;
        this.age = builder.age;
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
        private String teamName;
        private String lastName;
        private String firstName;
        private String nation;
        private String position;
        private String college;
        private String country;
        private Integer age;
        private Integer jerseyNumber;
        private String teamCity;
        private String height;
        private Double weight;
        private Integer draftYear;

        public Builder teamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder nation(String nation) {
            this.nation = nation;
            return this;
        }

        public Builder position(String position) {
            this.position = position;
            return this;
        }

        public Builder college(String college) {
            this.college = college;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder jerseyNumber(Integer jerseyNumber) {
            this.jerseyNumber = jerseyNumber;
            return this;
        }

        public Builder teamCity(String teamCity) {
            this.teamCity = teamCity;
            return this;
        }

        public Builder height(String height) {
            this.height = height;
            return this;
        }

        public Builder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public Builder draftYear(Integer draftYear) {
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
               nation == null && position == null && college == null && 
               country == null && age == null && jerseyNumber == null && 
               teamCity == null && height == null && weight == null && draftYear == null;
    }

    // Getters
    public String getTeamName() { return teamName; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getNation() { return nation; }
    public String getPosition() { return position; }
    public String getCollege() { return college; }
    public String getCountry() { return country; }
    public Integer getAge() { return age; }
    public Integer getJerseyNumber() { return jerseyNumber; }
    public String getTeamCity() { return teamCity; }
    public String getHeight() { return height; }
    public Double getWeight() { return weight; }
    public Integer getDraftYear() { return draftYear; }
}