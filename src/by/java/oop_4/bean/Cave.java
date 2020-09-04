package by.java.oop_4.bean;

import java.util.ArrayList;
import java.util.Objects;

public class Cave {

    /* Класс описывает пещеру дракона. */

    private String name;
    private Dragon dragon;
    private ArrayList<Treasure> treasures;

    public Cave()
    {
        name = "";
        dragon = null;
        treasures = new ArrayList<Treasure>();
    }

    public Cave(String name, ArrayList<Treasure> treasures) {
        this.name = name;
        dragon = null;
        this.treasures = treasures;
    }

    public Cave(String name) {
        this.name = name;
        dragon = null;
        treasures = new ArrayList<Treasure>();
    }

    public Cave(String name, Dragon dragon) {
        this.name = name;
        this.dragon = dragon;
        treasures = new ArrayList<Treasure>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public void addTreasure(Treasure treasure)
    {
        treasures.add(treasure);
    }

    public void removeTreasure(Treasure treasure)
    {
        treasures.remove(treasure);
    }

    public void clearTreasure()
    {
        treasures.clear();
    }

    @Override
    public String toString() {
        String text = (dragon != null) ? dragon.getName() : "";
        return name + text + treasures.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cave cave = (Cave) o;
        return Objects.equals(name, cave.name) &&
                Objects.equals(dragon, cave.dragon) &&
                Objects.equals(treasures, cave.treasures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dragon, treasures);
    }
}
