package com.example.ufc_backend;

public class Fighter {
    private String name;
    private Integer wins;
    private Integer losses;
    private Integer heightCms;
    private Integer reachCms;
    private Integer age;
    private String weightClass;
    
    // Constructor - this creates a new Fighter object
    public Fighter(String name, Integer wins, Integer losses, Integer heightCms, Integer reachCms, Integer age, String weightClass) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.heightCms = heightCms;
        this.reachCms = reachCms;
        this.age = age;
        this.weightClass = weightClass;
    }
    
    // Getters - these allow other code to read the fighter's data
    public String getName() { return name; }
    public Integer getWins() { return wins; }
    public Integer getLosses() { return losses; }
    public Integer getHeightCms() { return heightCms; }
    public Integer getReachCms() { return reachCms; }
    public Integer getAge() {return age;}
    public String getWeightClass() {return weightClass;}
}