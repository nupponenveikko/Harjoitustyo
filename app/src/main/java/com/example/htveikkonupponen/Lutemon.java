package com.example.htveikkonupponen;

public abstract class Lutemon {
    protected String name;
    protected String color;
    protected String location;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected int wins;
    protected int battles;
    protected int trainings;

    private static int idCounter = 0;

    public Lutemon(String name, String color, int attack, int defense, int maxHealth) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.experience = 0;
        this.location = "Koti";
        this.id = idCounter++;
        this.wins = 0;
        this.battles = 0;
        this.trainings = 0;
    }

    public int attack() {
        return attack + experience + (int)(Math.random() * 3);
    }

    public void defend(int damage) {
        int finalDamage = damage - defense;
        if (finalDamage < 0) {
            finalDamage = 0;
        }
        health -= finalDamage;
    }

    public void train() {
        experience++;
        trainings++;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void resetHealth() {
        health = maxHealth;
    }

    public void addWin() {
        wins++;
    }

    public void addBattle() {
        battles++;
    }

    public String getStats() {
        return color + " (" + name + ") ATTACK: " + attack +
                " DEFENCE: " + defense +
                " EXPERIENCE: " + experience +
                " HP: " + health + "/" + maxHealth +
                " BATTLES: " + battles +
                " WINS: " + wins +
                " TRAININGS: " + trainings;

    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getColor() { return color; }
    public String getLocation() { return location; }
    public void setLocation(String location) {
        this.location = location;
    }
}