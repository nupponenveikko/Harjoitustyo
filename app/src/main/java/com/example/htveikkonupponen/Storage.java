package com.example.htveikkonupponen;

import com.example.htveikkonupponen.Lutemon;
import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private static Storage instance;
    private HashMap<Integer, Lutemon> lutemons;

    private Storage() {
        lutemons = new HashMap<>();
    }
    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.put(lutemon.getId(), lutemon);
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

    public void removeLutemon(int id) {
        lutemons.remove(id);
    }

    public ArrayList<Lutemon> getAllLutemons() {
        return new ArrayList<>(lutemons.values());
    }

    public ArrayList<Lutemon> getByLocation(String location) {
        ArrayList<Lutemon> result = new ArrayList<>();

        for (Lutemon lutemon : lutemons.values()) {
            if (lutemon.getLocation().equals(location)) {
                result.add(lutemon);
            }
        }

        return result;
    }
    public void moveLutemon(int id, String location) {
        Lutemon lutemon = lutemons.get(id);
        if (lutemon != null) {
            lutemon.setLocation(location);
        }
    }
}
