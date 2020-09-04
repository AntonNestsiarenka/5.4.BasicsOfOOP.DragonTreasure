package by.java.oop_4.bean;

import java.util.Objects;

public class Dragon {

    /* Класс описывает дракона. */

    private String name;

    public Dragon()
    {
        name = "";
    }

    public Dragon(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dragon dragon = (Dragon) o;
        return Objects.equals(name, dragon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}