package by.java.oop_4.bean;

import java.util.Objects;

public class Treasure implements Comparable<Treasure> {

    /* Класс описывает сокровище. */

    private String name;
    double price; // usd

    public Treasure()
    {
        name = "";
        price = 0;
    }

    public Treasure(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "name='" + name + '\'' +
                ", price=" + price + " USD" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        return Double.compare(treasure.price, price) == 0 &&
                Objects.equals(name, treasure.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public int compareTo(Treasure o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }
}