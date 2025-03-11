package fr.ynov.java.medium;

import java.util.Objects;

public class Quality {

    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quality quality = (Quality) o;
        return id == quality.id && Objects.equals(name, quality.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static void main(String[] args) {
        Quality object1 = new Quality();
        object1.id = 1;
        object1.name = "awesome_object";
        Quality object2 = new Quality();
        object2.id = 1;
        object2.name = "awesome_object";

        System.out.println(object1 == object2);
        System.out.println(object1.equals(object2));
    }
}
